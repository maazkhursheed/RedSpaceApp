package com.example.myredspaceapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myredspaceapplication.model.Characters
import com.example.myredspaceapplication.network.RetrofitService

class CharactersViewModel : ViewModel() {

    private val characterService  = RetrofitService()

    fun getCharactersData() : MutableLiveData<Characters>? {
        return characterService.loadCharactersData()
    }

}