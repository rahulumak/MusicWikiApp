package com.rahulumak.greedygame.ggassignment.ui.genreList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class GenreListViewModel(private val repository: Repository) : ViewModel() {
    val itemList = MutableLiveData<List<GenreListModel.Toptags.Tag>>()
    val isExpanded = MutableLiveData<Boolean>()

    fun fetchGenreList(top10Only: Boolean): MutableLiveData<List<GenreListModel.Toptags.Tag>> {
        viewModelScope.launch(Dispatchers.IO) {
            var list = repository.getGenres().toptags.tag
            repository.deleteAllGenres()
            repository.saveGenres(list)
            if (top10Only) {
                list = list.subList(0, 10)
            }

            itemList.postValue(list)
            isExpanded.postValue(top10Only)
        }
        return itemList
    }
}