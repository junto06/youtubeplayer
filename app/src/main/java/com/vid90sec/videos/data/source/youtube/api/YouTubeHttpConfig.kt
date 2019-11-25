package com.vid90sec.videos.data.source.youtube.api

import com.vid90sec.videos.util.network.HttpConfig

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
object YouTubeHttpConfig:HttpConfig{
    override fun showHttpLogs(): Boolean  = true

    override fun baseUrl(): String = "https://www.googleapis.com/youtube/v3/"

}