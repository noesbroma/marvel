package com.example.marvel.data.list

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("available") val available: Int?
)