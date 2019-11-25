package com.vid90sec.videos.ui.playlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vid90sec.videos.domain.model.Video

abstract class PlayListViewHolder(view:View) : RecyclerView.ViewHolder(view){
    abstract fun setVideo(videoItem: Video)
}
