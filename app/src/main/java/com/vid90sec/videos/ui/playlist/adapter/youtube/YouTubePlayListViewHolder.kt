package com.vid90sec.videos.ui.playlist.adapter.youtube

import com.vid90sec.videos.databinding.YoutubePlaylistItemBinding
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.ui.playlist.adapter.PlayListViewHolder

class YouTubePlayListViewHolder(val item:YoutubePlaylistItemBinding) : PlayListViewHolder(item.rootItem){
    override fun setVideo(videoItem: Video) {
        item.item = videoItem
    }
}
