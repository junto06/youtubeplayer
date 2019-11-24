package com.vid90sec.videos.util.network

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class UrlHelperTest {

    @Test
    fun isValidUrl_EmptyUrl_ShouldReturnFalse() {
        var baseUrl = ""
        assertThat(UrlHelper.isValidUrl(baseUrl)).isFalse()
    }

    @Test
    fun isValidUrl_InvalidUrl_ShouldReturnFalse() {
        var baseUrl = "abc.com"
        assertThat(UrlHelper.isValidUrl(baseUrl)).isFalse()
    }

    @Test
    fun isValidUrl_validUrl_ShouldReturnTrue() {
        var baseUrl = "https://abc.com/"
        assertThat(UrlHelper.isValidUrl(baseUrl)).isTrue()
    }
}