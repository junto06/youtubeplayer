package com.vid90sec.videos.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent{
    fun provideRetrofit():Retrofit
}