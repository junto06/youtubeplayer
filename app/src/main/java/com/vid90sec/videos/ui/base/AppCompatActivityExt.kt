package com.vid90sec.videos.ui.base

import androidx.fragment.app.FragmentActivity
import com.vid90sec.videos.App
import com.vid90sec.videos.di.AppComponent
import com.vid90sec.videos.di.DaggerAppComponent
import com.vid90sec.videos.di.DaggerNetworkComponent
import com.vid90sec.videos.di.NetworkComponent

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
fun FragmentActivity.getAppComponent():AppComponent{
    return App.instance.getComponent()
}