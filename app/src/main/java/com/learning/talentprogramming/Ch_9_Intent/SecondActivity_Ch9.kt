package com.learning.talentprogramming.Ch_9_Intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivitySecondCh9Binding

class SecondActivity_Ch9 : AppCompatActivity() {
    private lateinit var binding : ActivitySecondCh9Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondCh9Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            btClick.setOnClickListener {
                setResult(RESULT_OK, Intent().putExtra("name", etName.text.toString()))
                finish()
            }
        }
    }
}