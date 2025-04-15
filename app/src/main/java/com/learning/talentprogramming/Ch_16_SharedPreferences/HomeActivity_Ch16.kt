package com.learning.talentprogramming.Ch_16_SharedPreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.databinding.ActivityMainCh16Binding

class HomeActivity_Ch16 : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var binding : ActivityMainCh16Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCh16Binding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences("MY_PREF", MODE_PRIVATE)
        binding.apply {
            setContentView(root)
            btLogout.setOnClickListener {
                sharedPreferences.edit().also {
                    it.putBoolean("isUserLoggedIn", false)
                    it.apply()
                }
                startActivity(Intent(this@HomeActivity_Ch16, LoginActivity_Ch16::class.java))
                finish()
            }
        }

    }
}