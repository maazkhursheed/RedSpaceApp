package com.example.myredspaceapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myredspaceapplication.R
import com.example.myredspaceapplication.interfaces.ItemClickListener
import com.example.myredspaceapplication.model.EpisodeResults
import com.jakewharton.rxbinding.view.RxView

class EpisodesListAdapter(private val episodesList: ArrayList<EpisodeResults>, private val itemClick: ItemClickListener): RecyclerView.Adapter<EpisodesListAdapter.ItemsViewHolder>() {

    companion object {
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_items, parent, false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        mItemClickListener = itemClick
        holder.episodeTitle?.text = episodesList[position].name
        holder.episodeAirDate?.text = episodesList[position].air_date
        holder.episodeCode?.text = episodesList[position].episode
        holder.characterLink?.text = "For more CLICK HERE"

        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return episodesList.size;
    }

    class ItemsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val episodeTitle: TextView = view.findViewById(R.id.episodeTitle)
        val episodeAirDate: TextView = view.findViewById(R.id.episodeAirDate)
        val episodeCode: TextView = view.findViewById(R.id.episodeCode)
        val characterLink: TextView = view.findViewById(R.id.characterLink)
        val mView = view
    }

}