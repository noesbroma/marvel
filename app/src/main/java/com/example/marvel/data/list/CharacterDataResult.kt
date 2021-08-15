package com.example.marvel.data.list

import com.google.gson.annotations.SerializedName

data class CharacterDataResult (
    @SerializedName("total") val total: Int?,
    @SerializedName("results") val results: ArrayList<CharacterListItem>
)