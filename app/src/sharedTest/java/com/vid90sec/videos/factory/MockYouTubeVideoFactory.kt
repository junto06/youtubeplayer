package com.vid90sec.videos.factory

import com.vid90sec.videos.data.source.youtube.model.ContentDetails
import com.vid90sec.videos.data.source.youtube.model.Snippet
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.VideoThumbnail

/**
 * Created by Mudassar Hussain on 11/25/2019.
 * MockYouTubeVideoFactory generates mock YouTubeVideos for testing purpose
 */
object MockYouTubeVideoFactory{

    fun getMockYouTubePlayList(videoCount:Int): YouTubePlayList {
        var list = mutableListOf<YouTubeVideoItem>()
        for(i in 0 until videoCount){
            list.add(getMockYouTubeVideo(id = i + 1))
        }
        return YouTubePlayList(items =  list)
    }

    fun getMockYouTubeVideo(id:Int = 1,content:String = "dummy-content",dummyUrl:String = "http:dummy.com"): YouTubeVideoItem {

        var videoThumbnail = VideoThumbnail(url = dummyUrl )

        var thumnails = mutableMapOf<String, VideoThumbnail>("default" to videoThumbnail)

        var snippet = Snippet(
            publishedAt = content,
            title = content,
            description = content,
            channelTitle = content,
            thumbnails = thumnails
        )

        var contentDetails = ContentDetails(
            videoId = id.toString(),
            videoPublishedAt = content
        )

        return YouTubeVideoItem(
            id = id.toString(),
            snippet = snippet,
            contentDetails =  contentDetails
        )
    }
}