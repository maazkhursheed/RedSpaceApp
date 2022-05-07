package com.example.myredspaceapplication.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myredspaceapplication.interfaces.ApiInterface
import com.example.myredspaceapplication.model.*
import com.example.myredspaceapplication.utils.AppConstants.BASE_URL
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitService {

    companion object Factory {

        val charactersResponse: MutableLiveData<CharactersList> = MutableLiveData()
        val locationsResponse: MutableLiveData<LocationsList> = MutableLiveData()
        val episodesResponse: MutableLiveData<EpisodesList> = MutableLiveData()
        var gson = GsonBuilder().setLenient().create()

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

        fun loadCharactersData(): MutableLiveData<CharactersList>? {

            val retrofitCall  = create().getAllCharacters()

            retrofitCall.enqueue(object : Callback<CharactersList> {
                override fun onFailure(call: Call<CharactersList>, t: Throwable?) {
                    Log.e("", t.toString())
                }

                override fun onResponse(call: Call<CharactersList>, response: retrofit2.Response<CharactersList>) {

                    val list  = response.body()
                    charactersResponse.value = list
                }

            })

            return charactersResponse
        }

        fun loadLocationsData(): MutableLiveData<LocationsList>? {

            val retrofitCall  = create().getAllLocations()

            retrofitCall.enqueue(object : Callback<LocationsList> {
                override fun onFailure(call: Call<LocationsList>, t: Throwable?) {
                }

                override fun onResponse(call: Call<LocationsList>, response: retrofit2.Response<LocationsList>) {

                    val list  = response.body()
                    locationsResponse.value = list
                }

            })

            return locationsResponse
        }

        fun loadEpisodesData(): MutableLiveData<EpisodesList>? {

            val retrofitCall  = create().getAllEpisodes()

            retrofitCall.enqueue(object : Callback<EpisodesList> {
                override fun onFailure(call: Call<EpisodesList>, t: Throwable?) {
                }

                override fun onResponse(call: Call<EpisodesList>, response: retrofit2.Response<EpisodesList>) {

                    val list  = response.body()
                    episodesResponse.value = list
                }

            })

            return episodesResponse
        }
    }
}