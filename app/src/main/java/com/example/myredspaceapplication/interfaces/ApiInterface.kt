package com.example.myredspaceapplication.interfaces

import com.example.myredspaceapplication.model.CharactersList
import com.example.myredspaceapplication.model.EpisodesList
import com.example.myredspaceapplication.model.LocationsList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("character")
    fun getAllCharacters(): Call<CharactersList>

    @GET("location")
    fun getAllLocations(): Call<LocationsList>

    @GET("episode")
    fun getAllEpisodes(): Call<EpisodesList>
}