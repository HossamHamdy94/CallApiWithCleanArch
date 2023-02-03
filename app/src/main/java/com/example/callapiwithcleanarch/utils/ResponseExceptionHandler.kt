
package com.example.callapiwithcleanarch.utils

import com.google.gson.Gson
import retrofit2.HttpException
import java.net.ConnectException
import java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.nio.charset.Charset

/**
 * Convert error returned from http call to custom exception
 *
 * @return
 * [NetworkException]
 *
 * [HTTP_UNAUTHORIZED]
 *
 * [GeneralHttpException]
 *
 * [HttpException] in case of Http Exception without error body of [ErrorBodyResponse]
 *
 * [UnknownException]
 */
fun Exception.handleHttpException(

): Throwable {
    return when (this) {
        is HttpException -> {
            when {
                code() == HTTP_GATEWAY_TIMEOUT -> {
                    NetworkException()
                }
                code() == HTTP_UNAUTHORIZED -> {
                    UnauthorizedException()
                }
                else -> {
                    getHttpThrowable(this,)
                }
            }
        }
        is SocketTimeoutException,
        is UnknownHostException,
        is UnsatisfiedLinkError,
        is ConnectException -> {
            NetworkException()
        }
        else -> {
            UnknownException("Some Thing went Wrong")
        }
    }
}

/**
 * @return
 * general http exception that contains [ErrorBodyResponse] after  and error body to be used in
 * future in remote data source.
 *
 * If any exception happened or the error body is empty the function will return the original http
 * exception.
 */
private fun getHttpThrowable(
    httpException: HttpException,
): Throwable {
    return try {
        val errorBody = httpException.cloneErrorBody()
        val responseBodyError = Gson().fromJson(
            errorBody,
            ErrorBodyResponse::class.java
        )
        if (responseBodyError.code == -1 && responseBodyError.message.isEmpty()) {

            httpException
        } else
            GeneralHttpException(
                responseBodyError,
                errorBody!!
            )
    } catch (e: Exception) {
        httpException
    }
}

/**
 * Clone the http exception error body because if we consumed it directly like
 * httpException.response()!!.errorBody()!!.string() we won't be able consume it again.
 *
 * As the first call will return the error body and the second will return empty.
 *
 * So we need to clone it in each consuming time to keep it as it's.
 *
 * @return error body as string
 */
fun HttpException.cloneErrorBody(): String? {
    val source = response()?.errorBody()?.source()
    source?.request(Long.MAX_VALUE); // request the entire body.
    val buffer = source?.buffer()
    // clone buffer before reading from it
    return buffer?.clone()?.readString(Charset.forName("UTF-8"))
}