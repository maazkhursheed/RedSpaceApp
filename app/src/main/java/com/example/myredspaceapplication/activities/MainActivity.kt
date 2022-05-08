package com.example.myredspaceapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myredspaceapplication.R
import com.example.myredspaceapplication.fragments.CharactersListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CharactersListFragment()
        showFragment(fragment)
    }

    private fun showFragment(fragment: CharactersListFragment) {
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.main_container,fragment)
        fram.commit()
    }
}