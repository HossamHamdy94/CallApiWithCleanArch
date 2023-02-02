package com.example.callapiwithcleanarch.utils

import android.os.Build
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object NetworkHelper {
    private lateinit var okHttpClient: OkHttpClient

    fun provideOkHttpClient(

    ): OkHttpClient {
        val body = HttpLoggingInterceptor()
        body.apply { body.level = HttpLoggingInterceptor.Level.BODY }
        val header = HttpLoggingInterceptor()
        header.apply { header.level = HttpLoggingInterceptor.Level.HEADERS }
        okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(body)
            .addInterceptor(header)
            .addInterceptor { chain ->
                val original = chain.request()
                val request =

                    original.newBuilder()
                            .header("Content-Type", "application/json")
                            .build()

                    chain.proceed(request)
            }.build()
        return okHttpClient

    }
}