package com.vid90sec.videos.ui.playlist.adapter.youtube

import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import com.vid90sec.videos.data.source.youtube.api.YouTubeApiConfig
import com.vid90sec.videos.databinding.YoutubePlaylistItemBinding
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.ui.playlist.adapter.PlayListViewHolder
import kotlinx.android.synthetic.main.youtube_playlist_item.view.*
import timber.log.Timber

class YouTubePlayListViewHolder(val item:YoutubePlaylistItemBinding) : PlayListViewHolder(item.rootItem){
    override fun setVideo(videoItem: Video) {
        item.item = videoItem
    }

    init {
        item.rootItem.thumbnail.initialize(YouTubeApiConfig.key(),object : YouTubeThumbnailView.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubeThumbnailView?, p1: YouTubeThumbnailLoader?) {
                p1?.setVideo(item.item?.videoId)
            }

            override fun onInitializationFailure(p0: YouTubeThumbnailView?, p1: YouTubeInitializationResult?) {
                Timber.d("YouTube onInitializationFailure")
            }
        })
    }
}
