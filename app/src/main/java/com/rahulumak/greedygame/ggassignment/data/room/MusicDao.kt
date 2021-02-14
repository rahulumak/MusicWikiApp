package com.rahulumak.greedygame.ggassignment.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rahulumak.greedygame.ggassignment.model.GenreListModel

@Dao
interface MusicDao {
    @Query("SELECT * FROM tag")
    fun getAllGenres(): List<GenreListModel.Toptags.Tag>

    @Insert
    fun saveGenres(genres: List<GenreListModel.Toptags.Tag>)

    @Query("DELETE FROM tag")
    fun deleteAllGenres()

}