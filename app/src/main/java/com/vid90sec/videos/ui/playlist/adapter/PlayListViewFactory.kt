package com.vid90sec.videos.ui.playlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vid90sec.videos.databinding.YoutubePlaylistItemBinding
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.ui.playlist.adapter.vimeo.VimeoPlayListViewHolder
import com.vid90sec.videos.ui.playlist.adapter.youtube.YouTubePlayListViewHolder

object PlayListViewFactory{
    fun <T : PlayListViewHolder> createViewHolder(itemLayout:Int,parent: ViewGroup,
                                                  viewType: Int,holderClass: Class<T>,listener:ActionPlayVideo): T{
        return with(holderClass){
            when{
                isAssignableFrom(YouTubePlayListViewHolder::class.java) ->{
                    var inflater = LayoutInflater.from(parent.context)
                    var viewBinding = DataBindingUtil.inflate<YoutubePlaylistItemBinding>(inflater, itemLayout,parent,false)
                    viewBinding.actionListener = listener
                    YouTubePlayListViewHolder(viewBinding)
                }
                isAssignableFrom(VimeoPlayListViewHolder::class.java) ->{
                    var inflater = LayoutInflater.from(parent.context)
                    var rootview = inflater.inflate(itemLayout,parent,false)
                    VimeoPlayListViewHolder(rootview)
            }
                else -> throw IllegalArgumentException("Unknown PlayListViewHolder class: ${holderClass.name}")
            }
        } as T
    }
}
