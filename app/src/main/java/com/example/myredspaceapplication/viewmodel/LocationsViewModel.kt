package com.example.myredspaceapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myredspaceapplication.model.Locations
import com.example.myredspaceapplication.network.RetrofitService

class LocationsViewModel : ViewModel() {

    private val locationService  = RetrofitService()

    fun getLocationsData() : MutableLiveData<Locations>? {
        return locationService.loadLocationsData()
    }
}