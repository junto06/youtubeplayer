package com.vid90sec.videos.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vid90sec.videos.R
import com.vid90sec.videos.databinding.FragmentPlaylistBinding
import com.vid90sec.videos.domain.interactor.VideoIntractor
import com.vid90sec.videos.domain.model.Video
import com.vid90sec.videos.ui.base.getAppComponent
import com.vid90sec.videos.ui.base.getViewModel
import com.vid90sec.videos.ui.playlist.adapter.ActionPlayVideo
import com.vid90sec.videos.ui.playlist.adapter.PlayListAdapter
import com.vid90sec.videos.ui.playlist.adapter.youtube.YouTubePlayListViewHolder
import com.vid90sec.videos.util.view.android.VideoItemSpaceDecoration
import com.vid90sec.videos.util.view.android.VideoLayoutManager
import javax.inject.Inject

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
class PlayListFragment:Fragment(){

    @Inject
    lateinit var videoIntractor: VideoIntractor

    lateinit var _playListViewModel: PlayListViewModel

    lateinit var databinding:FragmentPlaylistBinding

    lateinit var playListAdapter: PlayListAdapter<YouTubePlayListViewHolder>

    //TODO Vimeo change YouTubePlayListViewHolder to VimeoPlayListViewHolder same as below
    //lateinit var playListAdapter: PlayListAdapter<VimeoPlayListViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().getAppComponent().inject(this)

        _playListViewModel = getViewModel(PlayListViewModel::class.java,videoIntractor)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_playlist,container,false)

        databinding = FragmentPlaylistBinding.bind(rootView).apply {
            this.playListViewModel = _playListViewModel
        }

        databinding.lifecycleOwner = viewLifecycleOwner

        return databinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        setupErrorHandler()
        loadData()
    }

    private fun setupRecyclerView() {
        var layoutManager = VideoLayoutManager.getPlayListLayout(requireContext())
        databinding.playListRecyclerView.layoutManager = layoutManager
        databinding.playListRecyclerView.addItemDecoration(
            VideoItemSpaceDecoration(resources.getDimensionPixelSize(R.dimen.video_item_space)))


        //TODO Vimeo change YouTubePlayListViewHolder to VimeoPlayListViewHolder while adapter same as below
        //playListAdapter = PlayListAdapter(R.layout.vimeo_playlist_item,VimeoPlayListViewHolder::class.java)

        playListAdapter = PlayListAdapter(R.layout.youtube_playlist_item,YouTubePlayListViewHolder::class.java,
            object :ActionPlayVideo{
                override fun onPlayVideo(video: Video) {
                    var action = PlayListFragmentDirections.actionPlayVideo(video)
                    findNavController().navigate(action)
                }
            })
        databinding.playListRecyclerView.adapter = playListAdapter
    }

    private fun setupErrorHandler() {
        _playListViewModel.error.observe(this, Observer<String> { message ->
            Snackbar.make(requireNotNull(view), message, Snackbar.LENGTH_SHORT)
                .show()
        })
    }

    private fun loadData() {
        _playListViewModel.data.observe(this, Observer {data->
            playListAdapter.addPlayList(data)
        })

        _playListViewModel.loadChannelVideos()
    }
}