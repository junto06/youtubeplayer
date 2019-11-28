package com.vid90sec.videos.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.vid90sec.videos.App
import com.vid90sec.videos.R
import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import com.vid90sec.videos.di.DaggerTestAndroidAppComponent
import com.vid90sec.videos.di.MockVideoSourceModule
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.factory.MockYouTubeVideoFactory
import com.vid90sec.videos.ui.playlist.adapter.PlayListAdapter
import com.vid90sec.videos.ui.playlist.adapter.PlayListViewHolder
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    fun setupScenario(playList:YouTubePlayList?){
        //set app component before activity starts so activity doesn't set it

        var testComponent = DaggerTestAndroidAppComponent.builder()
            .mockVideoSourceModule(MockVideoSourceModule(playList)).build()

        App.instance.setTestComponent(testComponent)

        //start activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    fun setupMockData():YouTubePlayList{
        var mockPlayList = MockYouTubeVideoFactory.getMockYouTubePlayList(4);

        setupScenario(mockPlayList)

        return mockPlayList
    }

    @Test
    fun loadPlaylist_NoInternet_ShouldShowSnakbar() {

        setupScenario(null)

        onView(withId(R.id.mainFragment)).check(matches(isDisplayed()))

        //check if playListRecyclerView is visible
        onView(withId(R.id.playListRecyclerView)).check(matches(isDisplayed()))

        //check recylerview with zero items
        onView(withId(R.id.playListRecyclerView))
            .check(matches(viewMatcherRecyclerView{ it?.adapter?.itemCount!! == 0 }))

        //verify snakbar is shown with error message
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.data_loading_error)))
    }

    @Test
    fun loadPlaylist_ShouldPopulateRecylerView() {

        var mockPlayList = setupMockData()

        onView(withId(R.id.mainFragment)).check(matches(isDisplayed()))

        //check if playListRecyclerView is visible
        onView(withId(R.id.playListRecyclerView)).check(matches(isDisplayed()))

        //check if recylerview's adapter is instance of PlayListAdapter
        onView(withId(R.id.playListRecyclerView))
            .check(matches(viewMatcherRecyclerView{ it?.adapter is PlayListAdapter }))

        //check if recylerview's adapter data count is same as injected mock playlist
        onView(withId(R.id.playListRecyclerView))
            .check(matches(viewMatcherRecyclerView{ it?.adapter?.itemCount!! == mockPlayList.items.size }))

        //verify content of video item at position 0
        var itemPosition = 0
        var content = mockPlayList.items[itemPosition]

        //verify title
        onView(withId(R.id.playListRecyclerView))
            .check(matches(viewMatcherAtPosition(itemPosition, hasDescendant(withText(content.snippet.title)))))
        //verify description
        onView(withId(R.id.playListRecyclerView))
            .check(matches(viewMatcherAtPosition(itemPosition, hasDescendant(withText(content.snippet.description)))))
    }

    @Test
    fun openPlayer(){

        setupMockData()

        //open openPlayer screen
        var itemPosition = 0
        onView(withId(R.id.playListRecyclerView)).
            perform(actionOnItemAtPosition<PlayListViewHolder>(itemPosition, click()))

        //check if PlayerFragment is visible again
        onView(withId(R.id.youTubePlayerFragment)).check(matches(isDisplayed()))

        //check if YouTubePlayerView is visible again
        onView(withId(R.id.youtubePlayerView)).check(matches(isDisplayed()))

        //check if back button is visible
        onView(withContentDescription(R.string.abc_action_bar_up_description)).
            check(matches(isDisplayed()))


    }

    @Test
    fun testBackButtonOnPlayerScreen(){

        setupMockData()

        //open player screen
        var itemPosition = 0
        onView(withId(R.id.playListRecyclerView)).
            perform(actionOnItemAtPosition<PlayListViewHolder>(itemPosition, click()))

        //check if PlayerFragment is visible again
        onView(withId(R.id.youTubePlayerFragment)).check(matches(isDisplayed()))

        //check if back button is visible
        onView(withContentDescription(R.string.abc_action_bar_up_description))
            .check(matches(isDisplayed()))

        //check if back button is visible
        onView(withContentDescription(R.string.abc_action_bar_up_description))
            .perform(click())

        //check if PlayListFragment is visible again
        onView(withId(R.id.mainFragment)).check(matches(isDisplayed()))

        //open again
        itemPosition = 0
        onView(withId(R.id.playListRecyclerView)).perform(actionOnItemAtPosition<PlayListViewHolder>(itemPosition, click()))

        //press back button
        Espresso.pressBack()

        //check if PlayListFragment is visible again
        onView(withId(R.id.mainFragment)).check(matches(isDisplayed()))
    }
}