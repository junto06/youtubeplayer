package com.vid90sec.videos.util.network

import com.google.common.truth.Truth.assertThat
import okhttp3.OkHttpClient
import org.junit.Test

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class OkHttpHelperTest {

    @Test
    fun createHttpClient_ShouldReturnOkHttpClient() {

        var client = OkHttpHelper().createHttpClient()

        assertThat(client is OkHttpClient).isTrue()
    }
}