package com.vid90sec.videos.domain.interactor

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.di.DaggerTestAppComponent
import com.vid90sec.videos.di.MockVideoSourceModule
import com.vid90sec.videos.domain.repo.VideoRepository
import com.vid90sec.videos.factory.MockYouTubeVideoFactory
import com.vid90sec.videos.util.AssertHelper
import org.junit.Test
import javax.inject.Inject

/**
 * Created by Mudassar Hussain on 11/25/2019.
 * LoadPlayListVideoTest is integration test
 */
class LoadPlayListVideoTest{
    //subject under test
    lateinit var videoIntractor: VideoIntractor

    @Inject
    lateinit var videoRepository: VideoRepository


    fun setupTestDependency(youTubePlayList: YouTubePlayList?){
        var testComponent = DaggerTestAppComponent.builder().mockVideoSourceModule(MockVideoSourceModule(youTubePlayList)).build()
        testComponent.inject(this)
        videoIntractor = VideoIntractorImp(videoRepository)
    }

    @Test
    fun loadPlayList_shouldReturnPlaylist(){
        //setup dependency injection
        var count = 2
        var mockYoutubePlayList = MockYouTubeVideoFactory.getMockYouTubePlayList(count)
        setupTestDependency(mockYoutubePlayList)

        //loadPlayList
        var testObserver  = videoIntractor.loadPlayList().test()

        //verify
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertComplete()

        //verify with mock data

        var playlist = testObserver.values()[0]

        assertThat(playlist.items.size).isEqualTo(count)

        for(i in 0 until playlist.items.size){
            AssertHelper.assertVideoItem(playlist.items[i],mockYoutubePlayList.items[i])
        }
    }

    @Test
    fun loadPlayList_withError_shouldThrowException(){
        //injecting null as we are expecting error in the response
        setupTestDependency(null)

        //loadPlayList
        var testObserver  = videoIntractor.loadPlayList().test()

        //verify
        testObserver.awaitTerminalEvent()
        testObserver.assertError(Exception::class.java)
        testObserver.assertNoValues()
        testObserver.assertNotComplete()
    }
}