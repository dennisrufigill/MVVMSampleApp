package com.example.recyclerviewmvvmsimplifiedcoding

class MoviesRepository(private val api : MoviesAPI): SafeApiRequest() {

    suspend fun getMovies() = apiRequest{
        api.getMovies()
    }


}