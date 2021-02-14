package com.rahulumak.greedygame.ggassignment.ui.artistDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.AlbumModel
import com.rahulumak.greedygame.ggassignment.model.ArtistModel
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistDetailsViewModel(private val repository: Repository) : ViewModel() {
    val albumDetails= MutableLiveData<ArtistModel>()
    val tagList= MutableLiveData<List<GenreListModel.Toptags.Tag>>()
    fun getArtistInfo(artist:String): MutableLiveData<ArtistModel> {
        viewModelScope.launch (Dispatchers.IO){
            val genreInfoModel=repository.getArtistInfo(artist)
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
