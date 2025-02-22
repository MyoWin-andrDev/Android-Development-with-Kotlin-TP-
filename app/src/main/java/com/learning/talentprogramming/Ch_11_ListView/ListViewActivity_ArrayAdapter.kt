package com.learning.talentprogramming.Ch_11_ListView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
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
}