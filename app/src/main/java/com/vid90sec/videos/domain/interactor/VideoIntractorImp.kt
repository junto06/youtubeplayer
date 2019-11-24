package com.vid90sec.videos.domain.interactor

import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.repo.VideoRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Mudassar Hussain on 11/24/2019.
 * VideoIntractor is implemented for app business logic.
 * This layer is responsible to communicate with data layer as well.
 */
class VideoIntractorImp @Inject constructor(val videoRepository: VideoRepository) :VideoIntractor{
    override fun loadPlayList(): Observable<PlayList> {
        return videoRepository.getPlayList()
    }

}