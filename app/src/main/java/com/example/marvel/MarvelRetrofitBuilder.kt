package com.example.marvel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelRetrofitBuilder {
    companion object {
        private var retrofit_api: Retrofit? = null


        fun getRetrofitApi(): Retrofit? {
            if (retrofit_api == null) initRetrofitApi()

            return retrofit_api
        }


        private fun initRetrofitApi() {
            retrofit_api = Retrofit.Builder()
                .baseUrl(MarvelApplication.baseSecureHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            var b = ""
        }
    }
}