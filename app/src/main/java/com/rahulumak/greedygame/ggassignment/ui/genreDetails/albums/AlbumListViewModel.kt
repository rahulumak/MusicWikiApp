package com.rahulumak.greedygame.ggassignment.ui.genreDetails.albums

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumListViewModel(private val repository: Repository) : ViewModel() {
    val albumList = MutableLiveData<List<TopAlbumListModel.Albums.Album>>()
    fun fetchAlbumList(tag: String): MutableLiveData<List<TopAlbumListModel.Albums.Album>> {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getTopAlbums(tag).albums.album
            albumList.postValue(list)
        }
        return albumList
    }

}