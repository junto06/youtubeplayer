package com.vid90sec.videos.data.source.youtube.api

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
const val PLAYLIST_API_NAME = "playlistItems"

object YouTubeApiConfig{

    fun key() = "AIzaSyCY8tRjJ-28de4aH6jfrU_L5IOBwu5Q0ew"

    fun playlistId() = "PLyRfJw1I1N7HOCVMCJ3xpvKmAfZBv684-"

    fun part() = "snippet,contentDetails"

    fun playListResults() = 25

}