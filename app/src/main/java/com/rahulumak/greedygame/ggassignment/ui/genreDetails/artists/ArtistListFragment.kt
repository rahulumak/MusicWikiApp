package com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rahulumak.greedygame.ggassignment.databinding.ArtistListFragmentBinding
import com.rahulumak.greedygame.ggassignment.model.TopArtistLisModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsFragmentDirections
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistListFragment(private val genreName:String) : Fragment(),ArtistListAdapter.OnArtistItemClickListener {


    private val artistListViewModel: ArtistListViewModel by viewModel()
    private val artistListAdapter = ArtistListAdapter()
    private var binding: ArtistListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding != null) {
            return binding!!.root
        }
        binding = ArtistListFragmentBinding.inflate(inflater, container, false)
        context ?: return binding!!.root
        binding?.apply {
            lifecycleOwner = this@ArtistListFragment
            viewModel = artistListViewModel
            artistAdapter = artistListAdapter
        }
        val view = binding!!.root

        artistListViewModel.fetchArtistList(genreName)

        artistListAdapter.onArtistItemClickListener = this

        return view
    }

    override fun onItemClicked(tag: TopArtistLisModel.Topartists.Artist) {
        val direction = GenreDetailsFragmentDirections.actionNavigationGenreDetailsToNavigationArtistDetails(tag.name)
        findNavController().navigate(direction)
    }

}