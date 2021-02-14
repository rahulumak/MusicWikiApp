package com.rahulumak.greedygame.ggassignment.ui.genreDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.GenreDetailsFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class GenreDetailsFragment : Fragment() {

    private val genreDetailsViewModel: GenreDetailsViewModel by viewModel()
    private val args: GenreDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GenreDetailsFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            genreName = args.genreName
        }
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.toolbar.title = args.genreName
        genreDetailsViewModel.getGenreInfo(args.genreName).observe(viewLifecycleOwner, Observer{
            binding.genreInfo=it
        })
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = GenreDetailsPagerAdapter(this, args.genreName)

        // Set the text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        println(args.genreName)

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            ALBUM_INDEX -> getString(R.string.album)
            ARTIST_INDEX -> getString(R.string.artist)
            TRACK_INDEX -> getString(R.string.track)
            else -> null
        }
    }

}