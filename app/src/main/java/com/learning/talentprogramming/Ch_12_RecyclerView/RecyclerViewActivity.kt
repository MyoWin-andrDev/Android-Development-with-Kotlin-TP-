package com.learning.talentprogramming.Ch_12_RecyclerView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_12_RecyclerView.CustomListAdapter.LanguageAdapter
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
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
        val divider = DividerItemDecoration(this@RecyclerViewActivity, RecyclerView.VERTICAL) // binding.rvLanguage.addItemDecoration(divider)
        divider.setDrawable(resources.getDrawable(R.drawable.custom_divider))
        binding.rvLanguage.addItemDecoration(divider)
    }
}