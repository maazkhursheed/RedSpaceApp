package com.example.myredspaceapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myredspaceapplication.R
import com.example.myredspaceapplication.interfaces.ItemClickListener
import com.example.myredspaceapplication.model.CharacterResults
import com.jakewharton.rxbinding.view.RxView
import com.bumptech.glide.Glide

class CharactersListAdapter(private val charactersList: ArrayList<CharacterResults>, private val itemClick: ItemClickListener): RecyclerView.Adapter<CharactersListAdapter.ItemsViewHolder>() {

    companion object {
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_items, parent, false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        mItemClickListener = itemClick
        holder.characterTitle?.text = charactersList[position].name
        holder.characterStatus?.text = charactersList[position].status
        holder.characterGender?.text = charactersList[position].gender
        holder.characterData?.text = charactersList[position].species +"\n"+ charactersList[position].type

        Glide.with(holder.itemView.context).load(charactersList[position].image).placeholder(R.drawable.image)
            .into(holder.characterImage)

        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size;
    }

    class ItemsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var characterImage: ImageView = view.findViewById(R.id.characterImage)
        val characterTitle: TextView = view.findViewById(R.id.characterTitle)
        val characterStatus: TextView = view.findViewById(R.id.characterStatus)
        val characterGender: TextView = view.findViewById(R.id.characterGender)
        val characterData: TextView = view.findViewById(R.id.characterData)
        val mView = view
    }

}