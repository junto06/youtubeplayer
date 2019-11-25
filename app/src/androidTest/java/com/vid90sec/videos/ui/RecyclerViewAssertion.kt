package com.vid90sec.videos.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import com.vid90sec.videos.ui.playlist.adapter.PlayListViewHolder
import org.hamcrest.Description
import org.hamcrest.Matcher

/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
fun viewMatcherAtPosition(itemPosition:Int,itemMatcher: Matcher<View>): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java){
        override fun describeTo(description: Description?) {
            description?.appendText("viewMatcherAtPosition at position $itemPosition")
        }
        override fun matchesSafely(item: RecyclerView?): Boolean {
            var viewItem = item?.findViewHolderForAdapterPosition(itemPosition) as PlayListViewHolder
            return viewItem != null && itemMatcher.matches(viewItem.itemView)
        }
    }
}

fun viewMatcherRecyclerView(block:(RecyclerView?) -> Boolean): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java){
        override fun describeTo(description: Description?) {
            description?.appendText("viewMatcherRecyclerView with lambda")
        }
        override fun matchesSafely(item: RecyclerView?): Boolean {
            return block(item)
        }
    }
}
