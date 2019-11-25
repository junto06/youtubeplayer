package com.vid90sec.videos.di

import dagger.Component

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
@Component(modules = [VideoIntractorModule::class,VideoRepositoryModule::class,
    MockVideoSourceModule::class])
@VideoScope
interface TestAndroidAppComponent:AppComponent{

}