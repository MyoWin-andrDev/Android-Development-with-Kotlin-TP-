package com.learning.talentprogramming.Ch_11_ListView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.Ch_11_ListView.CustomListAdapter.SongAdapter
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityListViewHomeworkBinding

class ListViewActivity_Homework : AppCompatActivity() {
    private lateinit var binding  : ActivityListViewHomeworkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListViewHomeworkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListView()
    }
    private fun initListView(){
        val songsList = listOf("Hello",
            "Reptile Theme",
            "My Name Is Skrillex",
            "First of the Year",
            "Mind",
            "Sorry",
            "Bangarang",
            "Where Are Ü Now",
            "Stay",
            "Make It Bun Dem",
            "Kyoto",
            "Summit",
            "Get Up!",
            "Ruffneck (Full Flex)")

        val singersList = listOf(
            "Adele",
            "Skrillex",
            "Skrillex",
            "Skrillex",
            "Justin Bieber",
            "Skrillex",
            "Skrillex",
            "Jack Ü (Skrillex & Diplo)",
            "Zedd",
            "Skrillex",
            "Skrillex",
            "Skrillex",
            "Skrillex",
            "Skrillex"
        )

        val adapter = SongAdapter(songsList, singersList)
        binding.lvSong.adapter = adapter

    }
}