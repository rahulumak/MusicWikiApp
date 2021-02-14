package com.rahulumak.greedygame.ggassignment.di

import com.rahulumak.greedygame.ggassignment.ui.albumDetails.AlbumDetailViewModel
import com.rahulumak.greedygame.ggassignment.ui.artistDetails.ArtistDetailsViewModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsViewModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.albums.AlbumListViewModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists.ArtistListViewModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.tracks.TrackListViewModel
import com.rahulumak.greedygame.ggassignment.ui.genreList.GenreListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        GenreListViewModel(repository = get())
    }
    viewModel {
        GenreDetailsViewModel(repository = get())
    }
    viewModel {
        AlbumListViewModel(repository = get())
    }
    viewModel {
        ArtistListViewModel(repository = get())
    }
    viewModel {
        TrackListViewModel(repository = get())
    }
    viewModel {
        AlbumDetailViewModel(repository = get())
    }
    viewModel {
        ArtistDetailsViewModel(repository = get())
    }

}