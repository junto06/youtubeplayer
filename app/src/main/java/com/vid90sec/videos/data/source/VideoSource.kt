package com.vid90sec.videos.data.source

import com.vid90sec.videos.domain.model.PlayList
import io.reactivex.Observable

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
interface VideoSource{
    fun getPlayList(): Observable<PlayList>
}