package com.vid90sec.videos.data.source.youtube

import com.google.common.truth.Truth
import com.vid90sec.videos.data.source.youtube.api.YouTubeVideoApi
import com.vid90sec.videos.data.source.youtube.mapper.YouTubeToDomainMapper
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.data.source.youtube.model.YouTubeVideoItem
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.factory.MockVideoFactory
import com.vid90sec.videos.factory.MockYouTubeVideoFactory
import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class YouTubeVideoSourceTest {

    //subject under test
    lateinit var youTubeVideoSource: YouTubeVideoSource

    @Mock
    lateinit var youTubeVideoApi: YouTubeVideoApi

    @Mock
    lateinit var domainMapper: YouTubeToDomainMapper<YouTubePlayList, PlayList, YouTubeVideoItem, Video>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        youTubeVideoSource = YouTubeVideoSource(youTubeVideoApi,domainMapper)
    }

    @Test
    fun getPlayList_shouldGetPlayList(){

        //return mock data when youTubeVideoApi.loadYouTubePlayList() is called
        var mockYouTubePlayList = MockYouTubeVideoFactory.getMockYouTubePlayList(5)
        Mockito.`when`(youTubeVideoApi.loadYouTubePlayList()).thenReturn(Observable.just(mockYouTubePlayList))


        //return mock data when domainMapper.mockYouTubePlayList() is called
        var mockPlayList = MockVideoFactory.getMockPlayList(5)
        Mockito.`when`(domainMapper.toDomain(mockYouTubePlayList)).thenReturn(mockPlayList)


        //getPlayList
        var testObserver = youTubeVideoSource.getPlayList().test()

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