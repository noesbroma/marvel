package com.example.marvel.data.list

import com.google.gson.annotations.SerializedName

data class CharacterListItem (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail
)