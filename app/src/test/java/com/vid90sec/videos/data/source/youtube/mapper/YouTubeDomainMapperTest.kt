package com.vid90sec.videos.data.source.youtube.mapper

import com.google.common.truth.Truth.assertThat
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.factory.MockYouTubeVideoFactory
import com.vid90sec.videos.util.AssertHelper
import org.junit.Test

import org.junit.Before

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class YouTubeDomainMapperTest {

    //subject under test
    lateinit var youTubeDomainMapper:YouTubeDomainMapper

    @Before
    fun setup(){
        youTubeDomainMapper = YouTubeDomainMapper()
    }

    @Test
    fun toDomain_YouTubePlayList_ShouldConvertedToPlayList() {
        var count = 1
        var mockYoutubePlaylist = MockYouTubeVideoFactory.getMockYouTubePlayList(count)

        var playList = youTubeDomainMapper.toDomain(mockYoutubePlaylist)

        assertThat(playList.items.size == 1).isTrue()

        AssertHelper.assertVideoItem(playList.items[0],mockYoutubePlaylist.items[0])
    }

    @Test
    fun toDomain_YouTubeVideoItemList_ShouldConvertedToVideoList() {

        var mockYoutubeVideoItems = mutableListOf(MockYouTubeVideoFactory.getMockYouTubeVideo())

        var videoList = youTubeDomainMapper.toDomain(mockYoutubeVideoItems)

        assertThat(videoList.size == 1).isTrue()

        AssertHelper.assertVideoItem(videoList[0],mockYoutubeVideoItems[0])
    }

    @Test
    fun toDomainItem_YouTubeVideoItem_ShouldConvertedToVideo() {
        var mockYoutubeVideoItem = MockYouTubeVideoFactory.getMockYouTubeVideo()

        var video = youTubeDomainMapper.toDomainItem(mockYoutubeVideoItem)

        AssertHelper.assertVideoItem(video,mockYoutubeVideoItem)
    }


}