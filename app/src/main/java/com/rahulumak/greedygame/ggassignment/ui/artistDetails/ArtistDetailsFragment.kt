package com.rahulumak.greedygame.ggassignment.ui.artistDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.AlbumDetailFragmentBinding
import com.rahulumak.greedygame.ggassignment.databinding.ArtistDetailsFragmentBinding
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import com.rahulumak.greedygame.ggassignment.ui.albumDetails.AlbumDetailFragmentArgs
import com.rahulumak.greedygame.ggassignment.ui.albumDetails.AlbumDetailViewModel
import com.rahulumak.greedygame.ggassignment.ui.albumDetails.TagAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsFragmentArgs
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistDetailsFragment : Fragment(),TagAdapter.OnTagItemClickListener {

    private val args: ArtistDetailsFragmentArgs by navArgs()
    private val artistDetailsViewModel: ArtistDetailsViewModel by viewModel()

    private val tagAdapter = TagAdapter()
    private var binding: ArtistDetailsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding != null) {
            return binding!!.root
        }
        binding = ArtistDetailsFragmentBinding.inflate(inflater, container, false)
        context ?: return binding!!.root
        binding?.apply {
            lifecycleOwner = this@ArtistDetailsFragment
            viewModel = artistDetailsViewModel
            tagAdapter=tagAdapter
        }
        val view = binding!!.root

//        val list=albumDetailsViewModel.getSavedTagList()
//        Log.d("AlbumDetailFragment","list==>"+list.value!!.size)

        tagAdapter.onGenreItemClickListener = this

        artistDetailsViewModel.getArtistInfo(args.artistName).observe(viewLifecycleOwner, Observer{
            binding?.artistModel=it
        })
        return view
    }

    override fun onItemClicked(tag: GenreListModel.Toptags.Tag) {

    }
}