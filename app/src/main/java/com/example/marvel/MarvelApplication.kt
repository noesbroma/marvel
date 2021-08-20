package com.example.marvel

import android.app.Application
import com.example.marvel.di.detailModule
import com.example.marvel.di.listModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startDependencyInjection()
    }


    private fun startDependencyInjection() {
        startKoin {
            androidContext(this@MarvelApplication)
            modules(
                listOf(
                    listModule,
                    detailModule
                )
            )
        }
    }


    companion object {
        val baseSecureHost = "https://gateway.marvel.com/v1/public/"
    }
}