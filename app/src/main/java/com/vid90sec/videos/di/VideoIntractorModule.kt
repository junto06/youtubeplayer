package com.vid90sec.videos.di

import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.domain.interactor.VideoIntractorImp
import com.vid90sec.videos.domain.repo.VideoRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Module
class VideoIntractorModule{
    @Provides
    @VideoScope
    fun provideVideoIntractor(videoRepository: VideoRepository):VideoIntractor = VideoIntractorImp(videoRepository)
}