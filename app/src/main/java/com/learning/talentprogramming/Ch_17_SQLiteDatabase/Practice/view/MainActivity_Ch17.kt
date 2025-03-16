package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.view

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.Database.GenreDB
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.adapter.GenreAdapter
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.myUtilities.showToast
import com.learning.talentprogramming.databinding.ActivityMainCh17Binding
@RequiresApi(Build.VERSION_CODES.P)
class MainActivity_Ch17 : AppCompatActivity() {
    private lateinit var binding : ActivityMainCh17Binding
    private val genreDB = GenreDB(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCh17Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            rvGenre.adapter = GenreAdapter(this@MainActivity_Ch17, genreDB, genreDB.getAllGenre())
            rvGenre.addItemDecoration(DividerItemDecoration(this@MainActivity_Ch17, RecyclerView.VERTICAL))
            btAdd.setOnClickListener {
                if(genreDB.insertGenre(etGenre.text.toString())){
                    showToast("Genre Added Successfully")
                    etGenre.setText("")
                }
                else{
                    showToast("Something went wrong. Please try again.")
                }
                rvGenre.adapter = GenreAdapter(this@MainActivity_Ch17, genreDB, genreDB.getAllGenre())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.rvGenre.adapter = GenreAdapter(this@MainActivity_Ch17, genreDB,  genreDB.getAllGenre())
    }

    fun deleteFromDatabase(genreId : Int){
        genreDB.deleteGenre(genreId)
        binding.rvGenre.adapter = GenreAdapter(this@MainActivity_Ch17, genreDB,  genreDB.getAllGenre())
    }
}