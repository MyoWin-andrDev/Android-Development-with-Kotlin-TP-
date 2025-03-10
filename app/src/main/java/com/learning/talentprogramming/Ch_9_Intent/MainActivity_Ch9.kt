package com.learning.talentprogramming.Ch_9_Intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityMainCh9Binding

class MainActivity_Ch9 : AppCompatActivity() {
    private lateinit var binding : ActivityMainCh9Binding
    private final val REQUEST_CODE = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCh9Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            btClick.setOnClickListener {
                startActivityForResult(Intent(this@MainActivity_Ch9, SecondActivity_Ch9::class.java), REQUEST_CODE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            binding.tvName.text = data.getStringExtra("name")
        }
    }
}