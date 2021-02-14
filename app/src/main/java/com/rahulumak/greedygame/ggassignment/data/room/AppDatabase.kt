package com.rahulumak.greedygame.ggassignment.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rahulumak.greedygame.ggassignment.model.GenreListModel


@Database(entities = [GenreListModel.Toptags.Tag::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
        abstract fun getMusicDao():MusicDao
}