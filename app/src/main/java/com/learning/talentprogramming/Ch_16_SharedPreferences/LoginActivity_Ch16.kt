package com.learning.talentprogramming.Ch_16_SharedPreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.databinding.ActivityLoginCh16Binding

class LoginActivity_Ch16 : AppCompatActivity() {
    private lateinit var binding : ActivityLoginCh16Binding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginCh16Binding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences("MY_PREF", MODE_PRIVATE)
        binding.apply {
            setContentView(root)
            btLogin.setOnClickListener {
                sharedPreferences.edit().also {
                    it.putBoolean("isUserLoggedIn", true)
                    it.apply()
                }
                Intent(this@LoginActivity_Ch16, HomeActivity_Ch16::class.java).also {
                    startActivity(it)
                }
                finish()
            }

        }

    }
}