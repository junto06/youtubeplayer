package com.vid90sec.videos.util

import com.google.common.truth.Truth
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.Video

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
object AssertHelper{

    fun assertVideoItem(video: Video, youtuebeVide: YouTubeVideoItem) {
        video.apply {
            Truth.assertThat(videoId).isEqualTo(youtuebeVide.contentDetails.videoId)
            Truth.assertThat(videoTitle).isEqualTo(youtuebeVide.snippet.title)
            Truth.assertThat(videoDescription).isEqualTo(youtuebeVide.snippet.description)
            Truth.assertThat(channelTitle).isEqualTo(youtuebeVide.snippet.channelTitle)
            Truth.assertThat(publishedAt).isEqualTo(youtuebeVide.contentDetails.videoPublishedAt)
        }
    }
}