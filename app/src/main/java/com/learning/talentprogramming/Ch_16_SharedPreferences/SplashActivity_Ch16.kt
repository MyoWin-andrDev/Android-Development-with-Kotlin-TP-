package com.learning.talentprogramming.Ch_16_SharedPreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivitySplashCh16Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity_Ch16 : AppCompatActivity() {
    private lateinit var binding : ActivitySplashCh16Binding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashCh16Binding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("MY_PREF", MODE_PRIVATE)
        CoroutineScope(Dispatchers.Main).launch {
            val isUserLoggedIn = sharedPreferences.getBoolean("isUserLoggedIn", false)
            delay(3000L)
            val activity = if(isUserLoggedIn) MainActivity_Ch16::class.java else LoginActivity_Ch16::class.java
            startActivity(Intent(this@SplashActivity_Ch16, activity))
        }
    }
}