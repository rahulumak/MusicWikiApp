package com.rahulumak.greedygame.ggassignment.di


import com.rahulumak.greedygame.ggassignment.data.repository.Repository
import com.rahulumak.greedygame.ggassignment.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule= module {
    single<Repository> {
        RepositoryImpl(remoteDataSource = get(),localDataSource = get())
    }
}