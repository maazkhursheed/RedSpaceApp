package com.example.myredspaceapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myredspaceapplication.model.Episodes
import com.example.myredspaceapplication.network.RetrofitService

class EpisodesViewModel : ViewModel() {

    private val episodeService  = RetrofitService()

    fun getEpisodesData() : MutableLiveData<Episodes>? {
        return episodeService.loadEpisodesData()
    }

}