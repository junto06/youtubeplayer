package com.vid90sec.videos.factory

import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.domain.model.VideoThumbnail

/**
 * Created by Mudassar Hussain on 11/24/2019.
 *
 * MockVideoFactory generates mock videos for testing purpose
 */
object MockVideoFactory{

    fun getMockPlayList(videoCount:Int):PlayList{
        var list = mutableListOf<Video>()
        for(i in 0 until videoCount){
            list.add(getMockVideo(id = i+1))
        }
        return PlayList(items =  list)
    }

    fun getMockVideo(id:Int = 1,content:String = "dummy-content",dummyUrl:String = "http:dummy.com"):Video{
        var videoThumbnail = VideoThumbnail(url = dummyUrl )

        var thumnails = mutableMapOf<String,VideoThumbnail>("default" to videoThumbnail)

        return Video(
                videoId = id.toString(),
                videoTitle = content,
                videoDescription =  content,
                channelTitle =  content,
                publishedAt =  content,
                thumbnails =  thumnails
            )
    }
}