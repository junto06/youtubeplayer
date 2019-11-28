package com.vid90sec.videos.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
@Parcelize
data class Video(val videoId:String,val videoTitle:String,val videoDescription:String,
                 val channelTitle:String,val publishedAt:String,val thumbnails:Map<String,VideoThumbnail>): Parcelable