package com.vid90sec.videos.util.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class RetrofitHelper{

    fun createRetrofit(config:HttpConfig,client:OkHttpClient): Retrofit? {
        if(!UrlHelper.isValidUrl(config.baseUrl())){
            return null
        }
        return Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(config.baseUrl())
            .build()
    }
}