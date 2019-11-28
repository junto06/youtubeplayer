package com.vid90sec.videos.util.view.youtube

import androidx.databinding.BindingAdapter
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.vid90sec.videos.data.source.youtube.api.YouTubeApiConfig
import com.vid90sec.videos.domain.model.Video
import timber.log.Timber

/**
 * Created by Mudassar Hussain on 11/28/2019.
 */
@BindingAdapter("loadThumbnailView")
fun YouTubeThumbnailView.loadThumbnailView(videoId: String?) {
    initialize(YouTubeApiConfig.key(),object : YouTubeThumbnailView.OnInitializedListener{
        override fun onInitializationSuccess(p0: YouTubeThumbnailView?, p1: YouTubeThumbnailLoader?) {
            p1?.setVideo(videoId)
        }

        override fun onInitializationFailure(p0: YouTubeThumbnailView?, p1: YouTubeInitializationResult?) {
            Timber.d("YouTube onInitializationFailure")
        }
    })
}

@BindingAdapter("loadVideo")
fun YouTubePlayerView.loadVideo(video: Video) {
    addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            youTubePlayer.loadVideo(requireNotNull(video.videoId), 0f)
        }
    })
}