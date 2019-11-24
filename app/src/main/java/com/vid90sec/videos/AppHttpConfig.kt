package com.vid90sec.videos

import com.vid90sec.videos.util.network.HttpConfig

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
object AppHttpConfig:HttpConfig{
    override fun baseUrl(): String = "https://www.googleapis.com/youtube/v3/"

}