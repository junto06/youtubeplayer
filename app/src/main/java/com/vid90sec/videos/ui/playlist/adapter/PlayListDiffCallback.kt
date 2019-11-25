package com.vid90sec.videos.ui.playlist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.vid90sec.videos.domain.model.Video

class PlayListDiffCallback(private val oldItems: List<Video>,private  val newItems: List<Video>)
    : DiffUtil.Callback(){

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].videoId == newItems[newItemPosition].videoId
    }

    override fun getOldListSize(): Int  = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        var old = oldItems[oldItemPosition]
        var new = newItems[newItemPosition]
        return old == new
    }

}