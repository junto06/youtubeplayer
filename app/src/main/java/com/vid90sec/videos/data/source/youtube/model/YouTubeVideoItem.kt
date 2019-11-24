package com.vid90sec.videos.data.source.youtube.model

import com.vid90sec.videos.domain.model.VideoThumbnail

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
data class YouTubeVideoItem(val id:String,val snippet:Snippet,val contentDetails:ContentDetails)

data class Snippet(val publishedAt:String,val title:String,val description:String,val channelTitle:String,val thumbnails:Map<String, VideoThumbnail>)

data class ContentDetails(val videoId:String,val videoPublishedAt:String)