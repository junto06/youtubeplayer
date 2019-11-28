package com.vid90sec.videos.ui.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.ui.player.youtube.PlayerVideoModel
import com.vid90sec.videos.ui.playlist.PlayListViewModel

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class ViewModelFactory(private val context: Context,private val videoIntractor: VideoIntractor?): ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass){
            when{
                isAssignableFrom(PlayListViewModel::class.java) ->PlayListViewModel(context,requireNotNull(videoIntractor))
                isAssignableFrom(PlayerVideoModel::class.java) -> PlayerVideoModel()
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}