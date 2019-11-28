package com.vid90sec.videos.util.view.android

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Mudassar Hussain on 11/28/2019.
 */
class VideoItemSpaceDecoration(val offset:Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.left = offset
        outRect.right = offset
        outRect.bottom = offset

        if(parent.getChildLayoutPosition(view) == 0){
            outRect.top = offset
        }else{
            outRect.top = 0
        }

    }
}