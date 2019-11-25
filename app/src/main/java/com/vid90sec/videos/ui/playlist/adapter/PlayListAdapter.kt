package com.vid90sec.videos.ui.playlist.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vid90sec.videos.domain.model.PlayList
import com.vid90sec.videos.domain.model.Video

class PlayListAdapter<T:PlayListViewHolder>(val resLayoutId:Int,val holderClass: Class<T>,val listener:ActionPlayVideo): RecyclerView.Adapter<T>(){

    private val dataList = mutableListOf<Video>()

    fun  addPlayList(play:PlayList){
        synchronized(this){
            var result = DiffUtil.calculateDiff(PlayListDiffCallback(dataList,play.items))
            dataList.clear()
            dataList.addAll(play.items)
            result.dispatchUpdatesTo(this)
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return PlayListViewFactory.createViewHolder(resLayoutId,parent,viewType,holderClass,listener)
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        var video = dataList[position]
        holder.setVideo(video)
    }

}
