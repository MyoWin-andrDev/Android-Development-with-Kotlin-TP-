package com.learning.talentprogramming.Ch_11_ListView.CustomListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.learning.talentprogramming.databinding.ListViewSongBinding

class SongAdapter(val songsList : List<String>, val singersList : List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return songsList.size
    }

    override fun getItem(position : Int): Any {
        //TODO("Not yet implemented")
        return songsList[position]
    }

    override fun getItemId(position : Int): Long {
        //TODO("Not yet implemented")
        return 0
    }

    override fun getView(position : Int, view : View?, parent : ViewGroup?): View {
        //TODO("Not yet implemented")
        var v = view
        if( v == null){
            val layoutInflater = LayoutInflater.from(parent?.context)
            val binding = ListViewSongBinding.inflate(layoutInflater, parent, false)
            v = binding.root
            binding.txtTitle.text = songsList[position]
            binding.txtSinger.text = singersList[position]
        }
        return v
    }
}