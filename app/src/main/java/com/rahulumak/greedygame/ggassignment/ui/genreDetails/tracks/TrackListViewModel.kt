package com.rahulumak.greedygame.ggassignment.ui.genreDetails.tracks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.model.TopArtistLisModel
import com.rahulumak.greedygame.ggassignment.model.TopTrackListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrackListViewModel(private val repository: Repository): ViewModel() {
    val trackList = MutableLiveData<List<TopTrackListModel.Tracks.Track>>()
    fun fetchArtistList(tag: String): MutableLiveData<List<TopTrackListModel.Tracks.Track>> {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getTopTracks(tag).tracks.track
            trackList.postValue(list)
        }
        return trackList
    }
}