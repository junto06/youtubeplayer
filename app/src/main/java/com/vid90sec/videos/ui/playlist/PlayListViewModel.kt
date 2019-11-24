package com.vid90sec.videos.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.util.scheduler.AppScheduler
import com.vid90sec.videos.util.scheduler.IScheduler

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class PlayListViewModel(val videoIntractor: VideoIntractor,val scheduler:IScheduler = AppScheduler()):ViewModel(){

    //flag indicating operation already in progress
    private val _dataLoading: MutableLiveData<Boolean> = MutableLiveData()
    val dataLoading:MutableLiveData<Boolean>
        get() = _dataLoading


    //viewholder for our list data
    private val _data:MutableLiveData<PlayList> = MutableLiveData()
    val data:MutableLiveData<PlayList>
        get() = _data


    fun loadChannelVideos(){
        //return if already loading
        //This can happens when device get rotated and another request is already in process
        if(_dataLoading.value == true){
            return
        }
        _dataLoading.value = true

        videoIntractor.loadPlayList()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe {
                _data.value = it
                _dataLoading.value = false
            }

    }
}