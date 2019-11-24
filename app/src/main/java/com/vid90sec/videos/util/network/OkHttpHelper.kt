package com.vid90sec.videos.util.network

import okhttp3.OkHttpClient

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class OkHttpHelper{

    fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}