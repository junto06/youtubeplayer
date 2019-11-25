package com.vid90sec.videos.util.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */

class OkHttpHelper{

    fun createHttpClient(httpConfig: HttpConfig): OkHttpClient {
        var level = HttpLoggingInterceptor.Level.NONE
        if(httpConfig.showHttpLogs()){
            level = HttpLoggingInterceptor.Level.BODY
        }
        var loggingInterceptor = HttpLogger().loggingInterceptor(level)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
}