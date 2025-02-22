package com.learning.talentprogramming.Ch_11_ListView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.Ch_11_ListView.CustomListAdapter.LanguageListAdapter
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityListViewBaseAdapterBinding

class ListViewActivity_BaseAdapter : AppCompatActivity() {
    private lateinit var binding : ActivityListViewBaseAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListViewBaseAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBaseAdapter()
    }
    private fun initBaseAdapter(){
        val programmingLanguage = listOf("Bash", "C", "C#", "C++", "CSS", "Dart", "Git",
            "GitKraken", "Go", "Haskell", "HTML", "Java", "JavaScript", "Json", "Kotlin", "npm",
            "Python", "Ruby", "Rust", "TypeScript")

        val adapter = LanguageListAdapter(programmingLanguage)
        binding.lvProgrammingLanguage.adapter = adapter
    }

}