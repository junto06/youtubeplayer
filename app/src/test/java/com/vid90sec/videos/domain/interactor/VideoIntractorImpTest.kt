package com.vid90sec.videos.domain.interactor

import com.google.common.truth.Truth.assertThat
import com.vid90sec.videos.domain.repo.VideoRepository
import com.vid90sec.videos.factory.MockVideoFactory
import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class VideoIntractorImpTest {

    lateinit var videoIntractor: VideoIntractor

    @Mock
    lateinit var videoRepository: VideoRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        videoIntractor = VideoIntractorImp(videoRepository)
    }

    @Test
    fun loadPlayList_shouldReturnPlayList() {
        var mockPlayList = MockVideoFactory.getPlayList(3)

        //return mock data when videoIntractor.loadPlayList() is called
        Mockito.`when`(videoRepository.getPlayList()).thenReturn(Observable.just(mockPlayList))

        //loadPlayList
        var testObserver  = videoIntractor.loadPlayList().test()

        //verify
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertComplete()

        //verify with mock data

        var data = testObserver.values().get(0)

        assertThat(data).isEqualTo(mockPlayList)

    }
}