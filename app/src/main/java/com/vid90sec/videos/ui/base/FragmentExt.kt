package com.vid90sec.videos.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.vid90sec.videos.domain.interactor.VideoIntractor

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
fun <T : ViewModel> Fragment.getViewModel(viewModelClass: Class<T>, videoIntractor: VideoIntractor?=null): T {
    val context = (requireContext().applicationContext)
    return ViewModelProviders.of(this, ViewModelFactory(context,videoIntractor)).get(viewModelClass)
}