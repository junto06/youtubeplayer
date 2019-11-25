package com.vid90sec.videos.util.network

import android.content.Context
import com.vid90sec.videos.R
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
val TAG = "HttpError"
object ErrorHelper{

    fun logError(exception: Throwable,context: Context):String{

        var message = context.getString(R.string.data_loading_error)

        when(exception){
            is IOException -> {
                message = context.getString(R.string.data_loading_network_error)
                System.out.print("$TAG IOException Error message ${exception.message} ")
            }
            is HttpException -> System.out.print("$TAG HttpException Error code ${exception.code()} Error message ${exception.message()} ")
            else -> System.out.print("$TAG General exception ${exception.message} ")
        }
        return message
    }
}