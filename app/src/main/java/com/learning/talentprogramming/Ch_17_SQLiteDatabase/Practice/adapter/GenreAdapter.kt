package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.model.GenreModel
import com.learning.talentprogramming.databinding.ListViewGenreBinding

class GenreAdapter(val genreList: List<GenreModel>) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>(){

    class GenreViewHolder(var binding : ListViewGenreBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
         GenreViewHolder(ListViewGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int = genreList.size

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.apply {
            binding.tvGenre.text = genreList[position].genreName
        }
    }
}