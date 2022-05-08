package com.example.myredspaceapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myredspaceapplication.R
import com.example.myredspaceapplication.adapters.CharactersListAdapter
import com.example.myredspaceapplication.adapters.EpisodesListAdapter
import com.example.myredspaceapplication.interfaces.ItemClickListener
import com.example.myredspaceapplication.model.CharacterResults
import com.example.myredspaceapplication.model.Characters
import com.example.myredspaceapplication.model.EpisodeResults
import com.example.myredspaceapplication.model.Episodes
import com.example.myredspaceapplication.viewmodel.CharactersViewModel
import com.example.myredspaceapplication.viewmodel.EpisodesViewModel

class EpisodesFragment : Fragment() {
    private lateinit var rv_episodes_list: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episodes, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rv_episodes_list = itemView.findViewById(R.id.rv_episodes_list)

        val episodesViewModel = ViewModelProviders.of(this).get(EpisodesViewModel::class.java)
        episodesViewModel.getEpisodesData()?.observe(viewLifecycleOwner, Observer<Episodes>{ episodesList ->
            rv_episodes_list.adapter = EpisodesListAdapter(episodesList.results as ArrayList<EpisodeResults>, object : ItemClickListener {
                override fun onItemClick(pos: Int) {
                    Toast.makeText(activity,"item $pos clicked", Toast.LENGTH_LONG).show()
                }
            })
            rv_episodes_list.layoutManager = LinearLayoutManager(itemView.context)
            rv_episodes_list.setHasFixedSize(true)
        })
    }
}