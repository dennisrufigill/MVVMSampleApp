package com.example.recyclerviewmvvmsimplifiedcoding

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesAPI {

    @GET("marvel")
    suspend fun getMovies() : Response<List<CharactersItem>>

    companion object{

        operator fun invoke() : MoviesAPI{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://simplifiedcoding.net/demos/")
                .build()
                .create(MoviesAPI::class.java)
        }



    }


}