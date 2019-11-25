package com.vid90sec.videos.data.source.youtube.api

import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
interface YouTubeVideoApi{
    @GET(PLAYLIST_API_NAME)
    fun loadYouTubePlayList(@Query("part") part:String = YouTubeApiConfig.part(),
                @Query("maxResults") maxResult:Int = YouTubeApiConfig.playListResults(),
                            @Query("playlistId") playlistId:String = YouTubeApiConfig.playlistId(),
                            @Query("key") key:String = YouTubeApiConfig.key()): Observable<YouTubePlayList>
}