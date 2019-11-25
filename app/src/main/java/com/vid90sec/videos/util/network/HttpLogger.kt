package com.vid90sec.videos.util.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
const val TAG_NETWORK = "http-logs"
class HttpLogger{

    fun loggingInterceptor(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> Timber.d("$TAG_NETWORK : $message")
        })
        interceptor.level = level
        return interceptor
    }
}