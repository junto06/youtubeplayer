package com.vid90sec.videos.util.network

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import okhttp3.OkHttpClient
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class RetrofitHelperTest {

    //subject under test
    lateinit var retrofitHelper: RetrofitHelper

    @Mock
    lateinit var config:HttpConfig

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        retrofitHelper = RetrofitHelper()
    }

    @Test
    fun createRetrofit_ShouldReturnRetrofitClient() {

        Mockito.`when`(config.baseUrl()).thenReturn("https://abc.com/")

        var httpClient = OkHttpHelper().createHttpClient()

        var client = retrofitHelper.createRetrofit(config,httpClient)

        assertThat(client ).isNotNull()

        assertThat(client is Retrofit).isTrue()
    }
}