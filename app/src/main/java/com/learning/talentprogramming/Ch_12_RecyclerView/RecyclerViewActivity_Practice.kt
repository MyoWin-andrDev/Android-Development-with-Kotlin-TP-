package com.learning.talentprogramming.Ch_12_RecyclerView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_12_RecyclerView.CustomListAdapter.LanguageAdapter
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityRecyclerViewPracticeBinding

class RecyclerViewActivity_Practice : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerViewPracticeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView();
    }

    private fun initRecyclerView() {
       // TODO("Not yet implemented")
        val programmingLanguage = listOf("Bash", "C", "C#", "C++", "CSS", "Dart", "Git",
            "GitKraken", "Go", "Haskell", "HTML", "Java", "JavaScript", "Json", "Kotlin", "npm",
            "Python", "Ruby", "Rust", "TypeScript")

        val adapter = LanguageAdapter(programmingLanguage)
        binding.rvLanguage.adapter = adapter
        val divider = DividerItemDecoration(this@RecyclerViewActivity_Practice, RecyclerView.VERTICAL)
        divider.setDrawable(resources.getDrawable(R.drawable.custom_divider))
        binding.rvLanguage.addItemDecoration(divider)
        val customOffset = MyCustomOffset(40)
        binding.rvLanguage.addItemDecoration(customOffset)
    }
}