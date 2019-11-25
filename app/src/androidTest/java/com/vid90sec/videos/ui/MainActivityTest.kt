package com.vid90sec.videos.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.vid90sec.videos.App
import com.vid90sec.videos.R
import com.vid90sec.videos.di.DaggerTestAndroidAppComponent
import com.vid90sec.videos.di.MockVideoSourceModule
import com.vid90sec.videos.factory.MockVideoFactory
import com.vid90sec.videos.factory.MockYouTubeVideoFactory
import com.vid90sec.videos.ui.playlist.adapter.PlayListAdapter
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Test
    fun loadPlaylist_NoInternet_ShouldShowSnakbar() {

        //set app component before activity starts so activity doesn't set it

        var testComponent = DaggerTestAndroidAppComponent.builder()
            .mockVideoSourceModule(MockVideoSourceModule(null)).build()

        App.instance.setTestComponent(testComponent)

        //start activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.fragmentPlayList)).check(matches(isDisplayed()))

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
        //set app component before activity starts so activity doesn't set it

        var mockPlayList = MockYouTubeVideoFactory.getMockYouTubePlayList(4);

        var testComponent = DaggerTestAndroidAppComponent.builder()
            .mockVideoSourceModule(MockVideoSourceModule(mockPlayList)).build()

        App.instance.setTestComponent(testComponent)

        //start activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.fragmentPlayList)).check(matches(isDisplayed()))

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
}