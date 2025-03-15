package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.view

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.Database.GenreDB
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.adapter.GenreAdapter
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.model.GenreModel
import com.learning.talentprogramming.databinding.ActivityMainCh17Binding

class MainActivity_Ch17 : AppCompatActivity() {
    private lateinit var binding : ActivityMainCh17Binding
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCh17Binding.inflate(layoutInflater)
        val genreDB = GenreDB(this@MainActivity_Ch17)
        binding.apply {
            setContentView(root)
            val genreList = genreDB.getGenre()
            rvGenre.adapter = GenreAdapter(genreList)
            rvGenre.addItemDecoration(DividerItemDecoration(this@MainActivity_Ch17, RecyclerView.VERTICAL))
            btAdd.setOnClickListener {
                genreDB.insertGenre(etGenre.text.toString())
            }
        }
    }
}