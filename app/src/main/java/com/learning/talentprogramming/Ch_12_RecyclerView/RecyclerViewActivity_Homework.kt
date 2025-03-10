package com.learning.talentprogramming.Ch_12_RecyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_12_RecyclerView.CustomListAdapter.SongAdapter
import com.learning.talentprogramming.Ch_12_RecyclerView.CustomOffset.ViewOffset
import com.learning.talentprogramming.databinding.ActivityRecyclerViewHomeworkBinding

class RecyclerViewActivity_Homework : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerViewHomeworkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewHomeworkBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
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
                "Skrillex")

            rvSong.apply {
                adapter = SongAdapter(songsList, singersList)
                addItemDecoration(DividerItemDecoration(this@RecyclerViewActivity_Homework, RecyclerView.VERTICAL))
                //Practicing Offset On Purpose
                addItemDecoration(ViewOffset(16,8))
            }
        }
    }
}