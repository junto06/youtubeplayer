package com.vid90sec.videos.util.network

import com.google.common.truth.Truth.assertThat
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class OkHttpHelperTest {

    @Mock
    lateinit var config:HttpConfig

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun createHttpClient_ShouldReturnOkHttpClient() {

        `when`(config.showHttpLogs()).thenReturn(false)

        var client = OkHttpHelper().createHttpClient(config)

        assertThat(client is OkHttpClient).isTrue()
    }
}