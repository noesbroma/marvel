package com.example.marvel.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.list.GetCharactersListResult

import com.example.marvel.data.list.MarvelRepository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: MarvelRepository) : ViewModel() {
/*class ListViewModel() : ViewModel() {*/
    /*val onGetContentFileEvent = MutableLiveData<Boolean>()
    val onGetContentFileError = MutableLiveData<Boolean>()*/

    fun getCharacters() {
        viewModelScope.launch {
            val result = repository.getCharacters()

            when (result) {
                is GetCharactersListResult.Ok -> {
                    var a = ""
                }

                is GetCharactersListResult.Error -> {
                    var a = ""
                }
            }
        }
    }
}