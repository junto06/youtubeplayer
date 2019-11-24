package com.vid90sec.videos.domain.interactor

import com.google.common.truth.Truth.assertThat
import com.vid90sec.videos.domain.repo.VideoRepository
import com.vid90sec.videos.factory.MockVideoFactory
import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
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
        //return mock data when videoRepository.getPlayList() is called
        var mockPlayList = MockVideoFactory.getMockPlayList(3)
        `when`(videoRepository.getPlayList()).thenReturn(Observable.just(mockPlayList))

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