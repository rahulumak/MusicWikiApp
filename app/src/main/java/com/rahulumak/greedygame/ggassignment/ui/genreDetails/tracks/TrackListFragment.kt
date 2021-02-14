package com.rahulumak.greedygame.ggassignment.ui.genreDetails.tracks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.ArtistListFragmentBinding
import com.rahulumak.greedygame.ggassignment.databinding.TrackListFragmentBinding
import com.rahulumak.greedygame.ggassignment.model.TopArtistLisModel
import com.rahulumak.greedygame.ggassignment.model.TopTrackListModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists.ArtistListAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists.ArtistListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class TrackListFragment(private val genreName:String) : Fragment(),TrackListAdapter.OnTrackItemClickListener {


    private val trackListViewModel: TrackListViewModel by viewModel()
    private val trackListAdapter = TrackListAdapter()
    private var binding: TrackListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding != null) {
            return binding!!.root
        }
        binding = TrackListFragmentBinding.inflate(inflater, container, false)
        context ?: return binding!!.root
        binding?.apply {
            lifecycleOwner = this@TrackListFragment
            viewModel = trackListViewModel
            trackAdapter = trackListAdapter
        }
        val view = binding!!.root


        trackListViewModel.fetchArtistList(genreName)

        trackListAdapter.onTrackItemClickListener = this

        return view
    }

    override fun onItemClicked(tag: TopTrackListModel.Tracks.Track) {

    }

}