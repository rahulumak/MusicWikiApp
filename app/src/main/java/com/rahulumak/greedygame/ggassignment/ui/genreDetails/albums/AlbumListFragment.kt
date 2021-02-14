package com.rahulumak.greedygame.ggassignment.ui.genreDetails.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rahulumak.greedygame.ggassignment.databinding.AlbumListFragmentBinding
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsFragmentDirections
import org.koin.android.viewmodel.ext.android.viewModel

class AlbumListFragment(private val genreName: String) : Fragment(),
    AlbumListAdapter.OnAlbumItemClickListener {

    private val albumListViewModel: AlbumListViewModel by viewModel()
    private val albumListAdapter = AlbumListAdapter()
    private var binding: AlbumListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding != null) {
            return binding!!.root
        }
        binding = AlbumListFragmentBinding.inflate(inflater, container, false)
        context ?: return binding!!.root
        binding?.apply {
            lifecycleOwner = this@AlbumListFragment
            viewModel = albumListViewModel
            albumAdapter = albumListAdapter
        }
        val view = binding!!.root


        albumListViewModel.fetchAlbumList(genreName)

        albumListAdapter.onAlbumItemClickListener = this

        return view
    }

    override fun onItemClicked(tag: TopAlbumListModel.Albums.Album) {
        val direction = GenreDetailsFragmentDirections.actionNavigationGenreDetailsToNavigationAlbumDetails(tag.name,tag.artist.name)
        findNavController().navigate(direction)
    }


}