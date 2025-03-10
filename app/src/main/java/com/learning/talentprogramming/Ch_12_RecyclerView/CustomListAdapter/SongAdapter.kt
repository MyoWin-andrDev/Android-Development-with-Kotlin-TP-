package com.learning.talentprogramming.Ch_12_RecyclerView.CustomListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.R

class SongAdapter(private val songList : List<String> , private val singerList : List<String>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>(){

    //Practicing (findViewById) On Purpose
    class SongViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvSinger = itemView.findViewById<TextView>(R.id.tvSinger)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder =
        SongViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_song, parent, false))

    override fun getItemCount(): Int = songList.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.apply {
            tvTitle.text = songList[position]
            tvSinger.text = singerList[position]
        }
    }
}