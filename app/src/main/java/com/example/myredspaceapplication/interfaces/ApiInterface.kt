package com.example.myredspaceapplication.interfaces

import com.example.myredspaceapplication.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("character")
    fun getAllCharacters(): Call<Characters>

    @GET("location")
    fun getAllLocations(): Call<Locations>

    @GET("episode")
    fun getAllEpisodes(): Call<Episodes>
}