package com.vid90sec.videos.util.network

import java.net.URL

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
object UrlHelper{
    fun isValidUrl(baseUrl:String):Boolean{
        if(baseUrl.isNotEmpty()){
            try {
                var validURI = URL(baseUrl).toURI()
                return validURI != null
            }catch (ex:Exception){}
        }
        return false
    }
}