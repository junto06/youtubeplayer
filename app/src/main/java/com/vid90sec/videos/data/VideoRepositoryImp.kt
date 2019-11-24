package com.vid90sec.videos.data

import com.vid90sec.videos.data.source.VideoSource
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.repo.VideoRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class VideoRepositoryImp @Inject constructor(val videoSource: VideoSource):VideoRepository{
    override fun getPlayList(): Observable<PlayList> {
        return videoSource.getPlayList()
    }

}