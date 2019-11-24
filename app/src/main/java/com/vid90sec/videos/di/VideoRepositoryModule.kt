package com.vid90sec.videos.di

import com.vid90sec.videos.data.VideoRepositoryImp
import com.vid90sec.videos.data.source.VideoSource
import com.vid90sec.videos.domain.repo.VideoRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Module
class VideoRepositoryModule{
    @Provides
    @VideoScope
    fun provideVideoRepository(videoSource: VideoSource):VideoRepository = VideoRepositoryImp(videoSource)
}