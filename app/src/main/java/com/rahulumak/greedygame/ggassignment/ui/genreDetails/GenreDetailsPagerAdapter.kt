package com.rahulumak.greedygame.ggassignment.ui.genreDetails

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.albums.AlbumListFragment
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists.ArtistListFragment
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.tracks.TrackListFragment


const val ALBUM_INDEX = 0
const val ARTIST_INDEX = 1
const val TRACK_INDEX = 2

class GenreDetailsPagerAdapter(fragment: Fragment,genreName:String) : FragmentStateAdapter(fragment) {
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        ALBUM_INDEX to { AlbumListFragment(genreName) },
        ARTIST_INDEX to { ArtistListFragment(genreName) },
        TRACK_INDEX to { TrackListFragment(genreName) }
    )
    override fun getItemCount()= tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}