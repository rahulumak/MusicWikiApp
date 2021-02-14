package com.rahulumak.greedygame.ggassignment.ui.genreDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.GenreInfoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenreDetailsViewModel(private val repository: Repository) : ViewModel() {
    val genreDetails=MutableLiveData<GenreInfoModel>()
     fun getGenreInfo(tag:String):MutableLiveData<GenreInfoModel>{
        viewModelScope.launch (Dispatchers.IO){
            var genreInfoModel=repository.getGenreInfo(tag)
            genreDetails.postValue(genreInfoModel)
        }
        return genreDetails
    }
}