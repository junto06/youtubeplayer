package com.vid90sec.videos.di

import com.vid90sec.videos.data.source.youtube.YouTubeVideoSource
import com.vid90sec.videos.data.source.youtube.api.YouTubeVideoApi
import com.vid90sec.videos.data.source.youtube.mapper.YouTubeDomainMapper
import com.vid90sec.videos.data.source.youtube.mapper.YouTubeToDomainMapper
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Module
class VideoSourceModule{

    @Provides
    @VideoScope
    fun provideYouTubeVideoApi(retrofit: Retrofit) = retrofit.create(YouTubeVideoApi::class.java)

    @Provides
    @VideoScope
    fun provideYouTubeVideoMapper():YouTubeToDomainMapper<YouTubePlayList, PlayList, YouTubeVideoItem, Video> = YouTubeDomainMapper()

    @Provides
    @VideoScope
    fun provideVideoSource(youTubeVideoApi: YouTubeVideoApi,mapper: YouTubeToDomainMapper<YouTubePlayList, PlayList, YouTubeVideoItem, Video>)
            = YouTubeVideoSource(youTubeVideoApi,mapper)
}