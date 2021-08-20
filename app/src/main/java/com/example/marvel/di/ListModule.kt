package com.example.marvel.di

import com.example.marvel.MarvelRetrofitBuilder
import com.example.marvel.data.list.MarvelRepository
import com.example.marvel.data.list.CharactersApiService
import com.example.marvel.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.create

val listModule = module {
    viewModel {
        ListViewModel(get())
    }

    factory { MarvelRepository(charactersApiService = get()) }
    factory<CharactersApiService> { MarvelRetrofitBuilder.getRetrofitApi()!!.create(CharactersApiService::class.java) }
}