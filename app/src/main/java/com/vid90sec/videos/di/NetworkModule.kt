package com.vid90sec.videos.di

import com.vid90sec.videos.data.source.youtube.api.YouTubeHttpConfig
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
    fun provideHttpConfig():HttpConfig = YouTubeHttpConfig

    @Provides
    @Singleton
    fun provideHttpClient(httpConfig: HttpConfig):OkHttpClient = OkHttpHelper().createHttpClient(httpConfig)

    @Provides
    @Singleton
    fun provideRetrofitClient(httpConfig: HttpConfig,okHttpClient: OkHttpClient):Retrofit {
        return requireNotNull(RetrofitHelper().createRetrofit(httpConfig, okHttpClient))
    }
}