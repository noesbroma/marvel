package com.example.marvel.data.list

sealed class GetCharactersListResult {
    data class Ok(val getCharactersListResponse: GetCharactersListResponse) : GetCharactersListResult()
    object Error: GetCharactersListResult()
}
