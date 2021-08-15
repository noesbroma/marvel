package com.example.marvel.data.list

import com.google.gson.annotations.SerializedName


data class GetCharactersListResponse(
    /*val characters: ArrayList<Character>?*/
        @SerializedName("code") val code: String?,
        @SerializedName("data") val data: CharacterDataResult?
)
