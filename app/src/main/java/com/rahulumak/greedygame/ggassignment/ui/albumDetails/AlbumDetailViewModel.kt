package com.rahulumak.greedygame.ggassignment.ui.albumDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.AlbumModel
import com.rahulumak.greedygame.ggassignment.model.GenreInfoModel
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumDetailViewModel(private val repository: Repository) : ViewModel() {
    val albumDetails= MutableLiveData<AlbumModel>()
    val tagList= MutableLiveData<List<GenreListModel.Toptags.Tag>>()
    fun getAlbumInfo(album:String,artist:String): MutableLiveData<AlbumModel> {
        viewModelScope.launch (Dispatchers.IO){
            val genreInfoModel=repository.getAlbumInfo(album, artist)
            albumDetails.postValue(genreInfoModel)
        }
        return albumDetails
    }
    fun getSavedTagList(): MutableLiveData<List<GenreListModel.Toptags.Tag>> {
        viewModelScope.launch (Dispatchers.IO){
            val list=repository.getAllGenres()
            tagList.postValue(list)
        }
        return tagList
    }
}
