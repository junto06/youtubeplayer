package com.vid90sec.videos.data.source.youtube

import com.vid90sec.videos.data.source.VideoSource
import com.vid90sec.videos.data.source.youtube.api.YouTubeVideoApi
import com.vid90sec.videos.data.source.youtube.mapper.YouTubeToDomainMapper
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class YouTubeVideoSource @Inject constructor(private val youTubeVideoApi: YouTubeVideoApi, private val mapper: YouTubeToDomainMapper<YouTubePlayList,PlayList, YouTubeVideoItem, Video>):VideoSource{
    override fun getPlayList(): Observable<PlayList> {
        return youTubeVideoApi.loadYouTubePlayList()
                .map { mapper.toDomain(it) }
    }

}