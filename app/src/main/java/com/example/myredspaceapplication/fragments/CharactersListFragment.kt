package com.example.myredspaceapplication.fragments

import android.app.AlertDialog
import android.content.DialogInterface
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
import com.example.myredspaceapplication.interfaces.ItemClickListener
import com.example.myredspaceapplication.model.CharacterResults
import com.example.myredspaceapplication.model.Characters
import com.example.myredspaceapplication.viewmodel.CharactersViewModel

class CharactersListFragment : Fragment() {
    private lateinit var rv_characters_list: RecyclerView
    val positiveButtonClick = { dialog: DialogInterface, which: Int -> }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters_list, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rv_characters_list = itemView.findViewById(R.id.rv_characters_list)

        val charactersViewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        charactersViewModel.getCharactersData()?.observe(viewLifecycleOwner, Observer<Characters>{ charactersList ->
            rv_characters_list.adapter = CharactersListAdapter(charactersList.results as ArrayList<CharacterResults>, object : ItemClickListener {
                override fun onItemClick(pos: Int) {
                    showItemsDialog(pos,charactersList.results)
                }
            })
            rv_characters_list.layoutManager = LinearLayoutManager(itemView.context)
            rv_characters_list.setHasFixedSize(true)
        })
    }

    private fun showItemsDialog(pos: Int, results: ArrayList<CharacterResults>) {
        val items = arrayOf("Origin: " + results[pos].origin.name, "Location: " + results[pos].location.name, "Created at: " + results[pos].created)
        val builder = AlertDialog.Builder(this.context)
        with(builder)
        {
            setTitle(results[pos].name)
            setItems(items) { dialog, which -> }
            setPositiveButton("OK", positiveButtonClick)
            show()
        }

    }
}