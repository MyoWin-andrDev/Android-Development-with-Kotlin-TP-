package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.Database.GenreDB
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.model.GenreModel
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.view.EditActivity_Ch17
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.view.MainActivity_Ch17
import com.learning.talentprogramming.databinding.ListViewGenreBinding

class GenreAdapter(val context : Context,val genreDB: GenreDB, val genreList: List<GenreModel>) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>(){

    class GenreViewHolder(var binding : ListViewGenreBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
         GenreViewHolder(ListViewGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int = genreList.size

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.apply {
            binding.tvGenre.text = genreList[position].genreName
            //Update Bt
            binding.ivEdit.setOnClickListener {
                val intent = Intent(context, EditActivity_Ch17::class.java).also {
                    it.putExtra("genreId", genreList[position].genreId )
                    it.putExtra("genreName", genreList[position].genreName)
                }
                context.startActivity(intent)
            }
            //Delete Bt
            binding.ivDelete.setOnClickListener {
                (context as MainActivity_Ch17).deleteFromDatabase(genreList[position].genreId)
            }
        }
    }
}