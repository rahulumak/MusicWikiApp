package com.rahulumak.greedygame.ggassignment

import android.app.Application
import com.rahulumak.greedygame.ggassignment.di.*

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GreedyGameApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GreedyGameApplication)
            modules(networkModule)
            modules(repositoryModule)
            modules(dataSourceModule)
            modules(viewModelModule)
            modules(roomModule)
        }
    }
}