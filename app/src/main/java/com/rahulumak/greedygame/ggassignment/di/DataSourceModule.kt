package com.rahulumak.greedygame.ggassignment.di


import com.rahulumak.greedygame.ggassignment.data.local.LocalDataSource
import com.rahulumak.greedygame.ggassignment.data.local.LocalDataSourceImpl
import com.rahulumak.greedygame.ggassignment.data.remote.RemoteDataSource
import com.rahulumak.greedygame.ggassignment.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule= module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(musicWikiService = get())
    }
    single<LocalDataSource> {
        LocalDataSourceImpl(musicDao = get())
    }
}