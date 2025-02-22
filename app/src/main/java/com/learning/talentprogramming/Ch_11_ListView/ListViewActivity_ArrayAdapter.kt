package com.learning.talentprogramming.Ch_11_ListView

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.R

import com.learning.talentprogramming.databinding.ActivityListViewArrayAdapterBinding

class ListViewActivity_ArrayAdapter : AppCompatActivity() {
    private lateinit var binding : ActivityListViewArrayAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListViewArrayAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListView();
    }

    private fun initListView(){
        val programmingLanguage = arrayOf<String>("Bash", "C", "C#", "C++", "CSS", "Dart", "Git",
             "GitKraken", "Go", "Haskell", "HTML", "Java", "JavaScript", "Json", "Kotlin", "npm",
             "Python", "Ruby", "Rust", "TypeScript")

        val adapter : ArrayAdapter<String> = ArrayAdapter(this, R.layout.simple_list_item_1, programmingLanguage)
        binding.lvProgramming.adapter = adapter
    }

}