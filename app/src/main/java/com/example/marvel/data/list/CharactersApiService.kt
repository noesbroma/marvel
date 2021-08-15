package com.example.marvel.data.list

import retrofit2.http.*

interface CharactersApiService {

    @GET("characters")
    suspend fun getCharactersList(@Query("ts") ts: String,
                                   @Query("apikey") apikey: String,
                                   @Query("hash") hash: String): GetCharactersListResponse?
}