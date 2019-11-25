package com.vid90sec.videos.util.network

import android.content.Context
import com.google.common.truth.Truth.assertThat
import com.vid90sec.videos.R
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class ErrorHelperTest {

    @Mock
    lateinit var context: Context

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun logError_testIOException() {
        //test network ioexception
        var exception = IOException("Mock exception")

        `when`(context.getString(R.string.data_loading_error)).thenReturn( "")

        `when`(context.getString(R.string.data_loading_network_error)).thenReturn( "Network error")

        var result = ErrorHelper.logError(exception,context)

        assertThat(result).isEqualTo("Network error")
    }

    @Test
    fun logError_testHttpException() {
        //test Http exception like 401
        var response:Response<String> = Response.error(401, ResponseBody.create(MediaType.parse("text"),"text"))
        var exception = HttpException(response)

        `when`(context.getString(R.string.data_loading_error)).thenReturn( "Http error")

        `when`(context.getString(R.string.data_loading_network_error)).thenReturn( "Network error")

        var result = ErrorHelper.logError(exception,context)

        assertThat(result).isEqualTo("Http error")
    }

    @Test
    fun logError_testGeneralError() {
        //test general exception
        var exception = Exception("Mock exception")

        `when`(context.getString(R.string.data_loading_error)).thenReturn( "General error")

        `when`(context.getString(R.string.data_loading_network_error)).thenReturn( "Network error")

        var result = ErrorHelper.logError(exception,context)

        assertThat(result).isEqualTo("General error")
    }
}