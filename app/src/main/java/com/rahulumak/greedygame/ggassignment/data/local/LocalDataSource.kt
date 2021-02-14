package com.rahulumak.greedygame.ggassignment.data.local

import androidx.room.Insert
import androidx.room.Query
import com.rahulumak.greedygame.ggassignment.model.GenreListModel

interface LocalDataSource {
    suspend fun getAllGenres(): List<GenreListModel.Toptags.Tag>

    suspend fun saveGenres(genres: List<GenreListModel.Toptags.Tag>)

    suspend fun deleteAllGenres()
}
