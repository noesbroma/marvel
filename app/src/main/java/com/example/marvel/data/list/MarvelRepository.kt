package com.example.marvel.data.list

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelRepository(val charactersApiService: CharactersApiService) {
/*class MarvelRepository() {*/
    suspend fun getCharacters(): GetCharactersListResult {
        return withContext(Dispatchers.IO) {
            try {
                val response = charactersApiService.getCharactersList("1", "bd8cd7a922eb48861716dd00e7f8ef1c", "126cc92bf887ff867f70dcd0d29a2060")

                if (response != null) {
                    GetCharactersListResult.Ok(response)
                } else {
                    GetCharactersListResult.Error
                }
            } catch (e: Throwable) {
                GetCharactersListResult.Error
            }
        }
    }
}