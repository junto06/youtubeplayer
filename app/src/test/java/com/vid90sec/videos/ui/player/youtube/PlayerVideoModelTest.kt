package com.vid90sec.videos.ui.player.youtube

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.vid90sec.videos.factory.MockVideoFactory
import com.vid90sec.videos.util.LiveDataUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Mudassar Hussain on 11/27/2019.
 */
class PlayerVideoModelTest{
    //to run asyncTasks in synchronous way
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    //subject under test
    lateinit var playerViewModel: PlayerVideoModel

    @Before
    fun setup(){
        playerViewModel = PlayerVideoModel()
    }

    @Test
    fun testSetVideoItem(){

        //verify initial data is null
        var data = LiveDataUtil.getValue(playerViewModel.data)

        Truth.assertThat(data).isNull()

        var mockVideo = MockVideoFactory.getMockVideo()

        playerViewModel.setVideoItem(mockVideo)

        data = LiveDataUtil.getValue(playerViewModel.data)

        Truth.assertThat(data).isNotNull()

        Truth.assertThat(data).isEqualTo(mockVideo)
    }

}