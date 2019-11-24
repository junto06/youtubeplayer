package com.vid90sec.videos.di

import com.vid90sec.videos.AppHttpConfig
import com.vid90sec.videos.util.network.HttpConfig
import com.vid90sec.videos.util.network.OkHttpHelper
import com.vid90sec.videos.util.network.RetrofitHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Module
class NetworkModule{

    @Provides
    fun provideHttpConfig():HttpConfig = AppHttpConfig

    @Provides
    fun provideHttpClient():OkHttpClient = OkHttpHelper().createHttpClient()

    @Provides
    @Singleton
    fun provideRetrofitClient(httpConfig: HttpConfig,okHttpClient: OkHttpClient):Retrofit {
        return requireNotNull(RetrofitHelper().createRetrofit(httpConfig, okHttpClient))
    }
}