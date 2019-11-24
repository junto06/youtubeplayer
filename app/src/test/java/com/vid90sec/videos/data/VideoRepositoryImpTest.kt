package com.vid90sec.videos.data

import com.google.common.truth.Truth
import com.vid90sec.videos.data.source.VideoSource
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
class VideoRepositoryImpTest {

    //subject under test
    lateinit var videoRepository: VideoRepository

    @Mock
    lateinit var videoSource: VideoSource

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        videoRepository = VideoRepositoryImp(videoSource)
    }



    @Test
    fun getPlayList_shouldReturnPlayList() {
        //return mock data when videoSource.getPlayList() is called
        var mockPlayList = MockVideoFactory.getMockPlayList(5)
        `when`(videoSource.getPlayList()).thenReturn(Observable.just(mockPlayList))

        //getPlayList
        var testObserver  = videoRepository.getPlayList().test()

        //verify
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertComplete()

        //verify with mock data

        var data = testObserver.values().get(0)

        Truth.assertThat(data).isEqualTo(mockPlayList)
    }
}