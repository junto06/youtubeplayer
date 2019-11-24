package com.vid90sec.videos.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.ui.playlist.PlayListViewModel

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class ViewModelFactory(val videoIntractor: VideoIntractor): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        with(modelClass){
            when{
                isAssignableFrom(PlayListViewModel::class.java) ->PlayListViewModel(videoIntractor)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }
        return super.create(modelClass)
    }
}