package com.rahulumak.greedygame.ggassignment.ui.albumDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.AlbumDetailFragmentBinding
import com.rahulumak.greedygame.ggassignment.databinding.ArtistListFragmentBinding
import com.rahulumak.greedygame.ggassignment.databinding.GenreDetailsFragmentBinding
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsFragmentArgs
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsViewModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists.ArtistListAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class AlbumDetailFragment : Fragment(),TagAdapter.OnTagItemClickListener {

    private val albumDetailsViewModel: AlbumDetailViewModel by viewModel()
    private val args: AlbumDetailFragmentArgs by navArgs()
    private val tagAdapter = TagAdapter()
    private var binding: AlbumDetailFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding != null) {
            return binding!!.root
        }
         binding = AlbumDetailFragmentBinding.inflate(inflater, container, false)
        context ?: return binding!!.root
        binding?.apply {
            lifecycleOwner = this@AlbumDetailFragment
            viewModel = albumDetailsViewModel
            tagAdapter=tagAdapter
        }
        val view = binding!!.root

//        val list=albumDetailsViewModel.getSavedTagList()
//        Log.d("AlbumDetailFragment","list==>"+list.value!!.size)

        tagAdapter.onGenreItemClickListener = this

        albumDetailsViewModel.getAlbumInfo(args.albumName,args.artistName).observe(viewLifecycleOwner, Observer{
            binding?.albumInfo=it
        })
        return view
    }

    override fun onItemClicked(tag: GenreListModel.Toptags.Tag) {

    }
}