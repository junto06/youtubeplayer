package com.vid90sec.videos.di

import com.vid90sec.videos.data.source.VideoSource
import com.vid90sec.videos.data.source.youtube.YouTubeVideoSource
import com.vid90sec.videos.data.source.youtube.api.MockYouTubeVideoApi
import com.vid90sec.videos.data.source.youtube.api.YouTubeVideoApi
import com.vid90sec.videos.data.source.youtube.mapper.YouTubeDomainMapper
import com.vid90sec.videos.data.source.youtube.mapper.YouTubeToDomainMapper
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video
import dagger.Module
import dagger.Provides

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Module
class MockVideoSourceModule(val youTubePlayList: YouTubePlayList?){

    @Provides
    @VideoScope
    fun provideYouTubeVideoApi():YouTubeVideoApi = MockYouTubeVideoApi(youTubePlayList)

    @Provides
    @VideoScope
    fun provideYouTubeVideoMapper():YouTubeToDomainMapper<YouTubePlayList, PlayList, YouTubeVideoItem, Video> = YouTubeDomainMapper()

    @Provides
    @VideoScope
    fun provideVideoSource(youTubeVideoApi: YouTubeVideoApi,mapper: YouTubeToDomainMapper<YouTubePlayList, PlayList, YouTubeVideoItem, Video>): VideoSource
            = YouTubeVideoSource(youTubeVideoApi,mapper)
}