package com.vid90sec.videos.data.source.youtube.api

import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import io.reactivex.Observable

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
interface YouTubeVideoApi{
    fun loadYouTubePlayList(): Observable<YouTubePlayList>
}