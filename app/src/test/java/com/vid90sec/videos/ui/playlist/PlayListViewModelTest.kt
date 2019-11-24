package com.vid90sec.videos.ui.playlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.factory.MockVideoFactory
import com.vid90sec.videos.util.scheduler.IScheduler
import com.vid90sec.videos.util.scheduler.TestScheduler
import com.vid90sec.videos.util.LiveDataUtil.getValue
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class PlayListViewModelTest{

    //to run asyncTasks in synchronous way
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    //subject under test
    lateinit var playListViewModel: PlayListViewModel

    @Mock
    lateinit var videoIntractor: VideoIntractor

    lateinit var scheduler:IScheduler


    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        scheduler = TestScheduler
        playListViewModel = PlayListViewModel(videoIntractor,scheduler)
    }

    @Test
    fun loadChannelVideos_ShouldReturnPlayList(){

        //return mock data when videoIntractor.loadPlayList() is called
        var mockOutput = MockVideoFactory.getMockPlayList(3)
        `when`(videoIntractor.loadPlayList()).thenReturn(Observable.just(mockOutput))

        //loadChannelVideos
        playListViewModel.loadChannelVideos()

        //verify
        var data = getValue(playListViewModel.data)

        assertThat(data).isNotNull()

        assertThat(data).isEqualTo(mockOutput)

    }

    @Test
    fun loadChannelVideos_withError_ShouldThrowError(){

        //return mock error when videoIntractor.loadPlayList() is called
        var exception = Exception("Mock Exception!!")
        `when`(videoIntractor.loadPlayList()).thenReturn(Observable.error(exception))

        //loadChannelVideos
        playListViewModel.loadChannelVideos()

        var error = getValue(playListViewModel.error)

        //verify
        assertThat(error).isNotNull()
    }
}