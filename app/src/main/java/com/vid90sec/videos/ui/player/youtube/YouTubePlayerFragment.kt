package com.vid90sec.videos.ui.player.youtube

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.vid90sec.videos.R
import com.vid90sec.videos.databinding.YoutubePlayerFragmentBinding
import com.vid90sec.videos.ui.base.getViewModel


/**
 * Created by Mudassar Hussain on 11/26/2019.
 */
class YouTubePlayerFragment: Fragment(){

    lateinit var playerVideoModel: PlayerVideoModel

    lateinit var dataBinding: YoutubePlayerFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playerVideoModel = getViewModel(PlayerVideoModel::class.java)

        //set data to the viewmodel
        if(arguments != null) {
            playerVideoModel.setVideoItem(YouTubePlayerFragmentArgs.fromBundle(requireNotNull(arguments)).videoItem)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.youtube_player_fragment,container,false)

        dataBinding = YoutubePlayerFragmentBinding.bind(rootView).apply {
            videoModel = playerVideoModel
        }

        var youTubePlayerView = rootView.findViewById<View>(R.id.youtubePlayerView) as YouTubePlayerView

        lifecycle.addObserver(youTubePlayerView)

        return dataBinding.root
    }
}