package com.example.marvel.data.list

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("comics") val comics: Item,
    @SerializedName("series") val series: Item,
    @SerializedName("stories") val stories: Item,
    @SerializedName("events") val events: Item
): Serializable