package com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import com.rahulumak.greedygame.ggassignment.model.TopArtistLisModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistListViewModel(private val repository: Repository) : ViewModel() {
    val artistList = MutableLiveData<List<TopArtistLisModel.Topartists.Artist>>()
    fun fetchArtistList(tag: String): MutableLiveData<List<TopArtistLisModel.Topartists.Artist>> {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getTopArtists(tag).topartists.artist
            artistList.postValue(list)
        }
        return artistList
    }

}