package com.example.marvel.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.list.CharacterListItem
import com.example.marvel.data.list.GetCharactersListResult

import com.example.marvel.data.list.MarvelRepository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: MarvelRepository) : ViewModel() {
    val onLoadCharactersEvent = MutableLiveData<ArrayList<CharacterListItem>>()

    fun getCharacters() {
        viewModelScope.launch {
            when (val result = repository.getCharacters()) {
                is GetCharactersListResult.Ok -> {
                    onLoadCharactersEvent.value = result.getCharactersListResponse.data?.results
                }

                is GetCharactersListResult.Error -> {
                }
            }
        }
    }
}