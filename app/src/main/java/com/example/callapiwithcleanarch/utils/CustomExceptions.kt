package com.example.callapiwithcleanarch.utils

import java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT

/**
 * Exception represents IO exception or Http exception with code [HTTP_GATEWAY_TIMEOUT]
 */
class NetworkException : Exception("Network Exception")

/**
 * Exception represents Http Exception with error body of [ErrorBodyResponse]
 */
open class GeneralHttpException(
        val errorBodyResponse: ErrorBodyResponse,
        val errorBody: String
) : Exception("General Http Exception")

/**
 * Exception represents unauthorized user
 */
class UnauthorizedException : Exception("Unauthorized Exception")

/**
 * Exception represents any unknown Exception
 */
class UnknownException(message: String) : Exception(message)
