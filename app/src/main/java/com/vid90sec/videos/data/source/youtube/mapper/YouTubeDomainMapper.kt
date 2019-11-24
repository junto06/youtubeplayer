package com.vid90sec.videos.data.source.youtube.mapper

import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video

/**
 * Created by Mudassar Hussain on 11/25/2019.
 *
 * YouTubeDomainMapper is used to map Youtube Objects to Domain Objects
 */
class YouTubeDomainMapper:YouTubeToDomainMapper<YouTubePlayList,PlayList,YouTubeVideoItem,Video> {
    override fun toDomain(from: YouTubePlayList): PlayList {
        return PlayList(items =  toDomain(from.items))
    }

    override fun toDomain(from: List<YouTubeVideoItem>): List<Video> {
        var result = mutableListOf<Video>()
        from.forEach{
            result.add(toDomainItem(it))
        }
        return result
    }

    override fun toDomainItem(from: YouTubeVideoItem): Video {

        return with(from){
            Video(videoId = contentDetails.videoId,
                videoTitle = snippet.title,
                videoDescription =  snippet.description,
                channelTitle =  snippet.channelTitle,
                publishedAt =  contentDetails.videoPublishedAt,
                thumbnails =  snippet.thumbnails
                )
        }
    }
}