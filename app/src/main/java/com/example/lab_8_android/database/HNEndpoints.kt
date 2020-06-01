package com.example.lab_8_android.database

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HNEndpoints {

    @GET("/3/movie/popular")
    fun getNews(@Query("api_key") key:String): Call<PopularMovies>
}