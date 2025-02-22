package com.learning.talentprogramming.Ch_6_ViewControls

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityMainCh6Binding

class MainActivity_Ch6 : AppCompatActivity() {
    private lateinit var binding : ActivityMainCh6Binding
    private var etText : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainCh6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getEtText()
    }

    private fun getEtText(){
        binding.btn.setOnClickListener {
            etText = binding.et.text.toString()
            binding.txt.text = etText
        }
    }
}