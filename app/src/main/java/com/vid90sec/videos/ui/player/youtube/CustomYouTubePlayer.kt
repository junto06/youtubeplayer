package com.vid90sec.videos.ui.player.youtube

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vid90sec.videos.R

/**
 * Created by Mudassar Hussain on 11/26/2019.
 */
class CustomYouTubePlayer: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.custom_youtube_fragment,container,false)

        return rootView
    }
}