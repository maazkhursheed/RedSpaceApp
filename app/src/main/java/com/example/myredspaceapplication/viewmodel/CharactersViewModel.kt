package com.example.myredspaceapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myredspaceapplication.model.CharactersList
import com.example.myredspaceapplication.network.RetrofitService

class CharactersViewModel : ViewModel() {

    private val characterService  = RetrofitService

    fun getCharactersData() : MutableLiveData<CharactersList>? {
        return characterService.loadCharactersData()
    }

}