package com.vid90sec.videos.ui.playlist

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.util.network.ErrorHelper
import com.vid90sec.videos.util.scheduler.AppScheduler
import com.vid90sec.videos.util.scheduler.IScheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class PlayListViewModel(private val context: Context,private val videoIntractor: VideoIntractor,private val scheduler:IScheduler = AppScheduler()):ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    //flag indicating operation already in progress
    private val _dataLoading: MutableLiveData<Boolean> = MutableLiveData()
    val dataLoading:MutableLiveData<Boolean>
        get() = _dataLoading


    //viewholder for our list data
    private val _data:MutableLiveData<PlayList> = MutableLiveData()
    val data:MutableLiveData<PlayList>
        get() = _data


    //viewholder for error state
    private val _error:MutableLiveData<String> = MutableLiveData()
    val error:MutableLiveData<String>
        get() = _error


    fun loadChannelVideos(){
        //return if already loading
        //This can happens when device get rotated and another request is already in process
        if(_dataLoading.value == true){
            return
        }
        _dataLoading.value = true

        var disposable = videoIntractor.loadPlayList()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe ({
                System.out.println(it.toString())
                _data.value = it
                _dataLoading.value = false
            },
                {
                    _error.value = ErrorHelper.logError(it,context)
                    _dataLoading.value = false
                })

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}