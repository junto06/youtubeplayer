package com.vid90sec.videos.di

import com.vid90sec.videos.ui.playlist.PlayListFragment
import dagger.Component

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Component(modules = [VideoIntractorModule::class,VideoRepositoryModule::class, VideoSourceModule::class],
    dependencies = [NetworkComponent::class])
@VideoScope
interface AppComponent{
    fun inject(target: PlayListFragment)
}