package com.example.myredspaceapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myredspaceapplication.R
import com.example.myredspaceapplication.adapters.ViewPagerAdapter
import com.example.myredspaceapplication.fragments.CharactersListFragment
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.myredspaceapplication.fragments.EpisodesFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)

        setSupportActionBar(bar)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(CharactersListFragment(), "Characters")
        adapter.addFragment(EpisodesFragment(), "Episodes")

        pager.adapter = adapter
        tab.setupWithViewPager(pager)
    }
}