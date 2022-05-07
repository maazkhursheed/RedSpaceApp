package com.example.myredspaceapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myredspaceapplication.model.CharactersList
import com.example.myredspaceapplication.viewmodel.CharactersViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val charactersViewModel = ViewModelProviders.of(this@MainActivity).get(CharactersViewModel::class.java)
        charactersViewModel.getCharactersData()?.observe(this, Observer<CharactersList>{ charactersList ->

            charactersList?.toString()?.let { Log.e("list", it) }
        })
    }
}