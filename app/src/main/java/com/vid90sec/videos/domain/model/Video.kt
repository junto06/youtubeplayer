package com.vid90sec.videos.domain.model

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
data class Video(val videoId:String,val videoTitle:String,val videoDescription:String,
                 val channelTitle:String,val publishedAt:String,val thumbnails:Map<String,VideoThumbnail>)