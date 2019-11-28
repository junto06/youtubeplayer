package com.vid90sec.videos.util.view.android

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vid90sec.videos.R

/**
 * Created by Mudassar Hussain on 11/26/2019.
 */
object VideoLayoutManager{
    fun getPlayListLayout(context:Context):LinearLayoutManager{
        return if(context.resources.getBoolean(R.bool.horizontal_grid)){
            GridLayoutManager(context,context.resources.getInteger(R.integer.number_of_columns_or_row),RecyclerView.HORIZONTAL,false)
        }else {
            GridLayoutManager(context,context.resources.getInteger(R.integer.number_of_columns_or_row))
        }
    }
}