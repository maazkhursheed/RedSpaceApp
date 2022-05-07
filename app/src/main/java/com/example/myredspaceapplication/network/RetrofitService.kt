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

class RetrofitService {

    val charactersResponse: MutableLiveData<Characters> = MutableLiveData()
    val episodesResponse: MutableLiveData<Episodes> = MutableLiveData()
    val locationsResponse: MutableLiveData<Locations> = MutableLiveData()

    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }

    fun loadCharactersData(): MutableLiveData<Characters>? {

        val retrofitCall  = create().getAllCharacters()

        retrofitCall.enqueue(object : Callback<Characters> {
            override fun onFailure(call: Call<Characters>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error")
            }

            override fun onResponse(call: Call<Characters>, response: retrofit2.Response<Characters>) {

                val list  = response.body()
                charactersResponse.value = list

                Log.e("hasActiveObservers 1", charactersResponse.hasActiveObservers().toString()+" check")

                Log.e("on response 2 :", charactersResponse.toString()+" check")

            }

        })

        return charactersResponse
    }

    fun loadEpisodesData(): MutableLiveData<Episodes>? {

        val retrofitCall  = create().getAllEpisodes()

        retrofitCall.enqueue(object : Callback<Episodes> {
            override fun onFailure(call: Call<Episodes>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error")
            }

            override fun onResponse(call: Call<Episodes>, response: retrofit2.Response<Episodes>) {

                val list  = response.body()
                episodesResponse.value = list

                Log.e("hasActiveObservers 1", episodesResponse.hasActiveObservers().toString()+" check")

                Log.e("on response 2 :", episodesResponse.toString()+" check")

            }

        })

        return episodesResponse
    }

    fun loadLocationsData(): MutableLiveData<Locations>? {

        val retrofitCall  = create().getAllLocations()

        retrofitCall.enqueue(object : Callback<Locations> {
            override fun onFailure(call: Call<Locations>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error")
            }

            override fun onResponse(call: Call<Locations>, response: retrofit2.Response<Locations>) {

                val list  = response.body()
                locationsResponse.value = list

                Log.e("hasActiveObservers 1", locationsResponse.hasActiveObservers().toString()+" check")

                Log.e("on response 2 :", locationsResponse.toString()+" check")

            }

        })

        return locationsResponse
    }
}

