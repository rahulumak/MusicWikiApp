package com.rahulumak.greedygame.ggassignment.data.local

import com.rahulumak.greedygame.ggassignment.data.room.MusicDao
import com.rahulumak.greedygame.ggassignment.model.GenreListModel


class LocalDataSourceImpl(private val musicDao: MusicDao) : LocalDataSource {
    override suspend fun getAllGenres(): List<GenreListModel.Toptags.Tag> {
        return musicDao.getAllGenres()
    }

    override suspend fun saveGenres(genres: List<GenreListModel.Toptags.Tag>) {
        musicDao.saveGenres(genres)
    }

    override suspend fun deleteAllGenres() {
        musicDao.deleteAllGenres()
    }

}