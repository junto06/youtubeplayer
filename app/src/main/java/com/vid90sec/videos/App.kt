package com.vid90sec.videos

import android.app.Application
import androidx.annotation.VisibleForTesting
import com.vid90sec.videos.di.AppComponent
import com.vid90sec.videos.di.DaggerAppComponent
import com.vid90sec.videos.di.DaggerNetworkComponent
import timber.log.Timber

class App : Application() {

    companion object{
        lateinit var instance:App
    }

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        instance = this

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

    fun getComponent():AppComponent{
        if(appComponent == null){
            var networkComponent = DaggerNetworkComponent.create()
            appComponent = DaggerAppComponent.builder().networkComponent(networkComponent).build()
        }
        return requireNotNull(appComponent)
    }

    @VisibleForTesting
    fun setTestComponent(component:AppComponent){
        appComponent = component
    }
}
