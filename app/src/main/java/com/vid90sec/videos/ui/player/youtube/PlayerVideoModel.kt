package com.vid90sec.videos.ui.player.youtube

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vid90sec.videos.domain.model.Video

/**
 * Created by Mudassar Hussain on 11/27/2019.
 */
class PlayerVideoModel:ViewModel(){

    //viewholder containing video item
    private val _data:MutableLiveData<Video> = MutableLiveData()
    val data:MutableLiveData<Video>
        get() = _data



    fun setVideoItem(video: Video){
        _data.value = video
    }

}