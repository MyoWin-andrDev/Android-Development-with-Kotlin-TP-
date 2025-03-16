package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.Database.GenreDB
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.myUtilities.showToast
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityEditCh17Binding

class EditActivity_Ch17 : AppCompatActivity() {
    private lateinit var binding : ActivityEditCh17Binding
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCh17Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            val genreId = intent.getIntExtra("genreId", 0)
            val genreName = intent.getStringExtra("genreName")
            etGenre.setText(genreName)
            btUpdate.setOnClickListener {
                if (GenreDB(this@EditActivity_Ch17).updateGenre(genreId,etGenre.text.toString())) {
                    finish()
                    showToast("Successfully Updated")
                }
                else{
                    showToast("Something went wrong")
                }
            }
        }
    }
}