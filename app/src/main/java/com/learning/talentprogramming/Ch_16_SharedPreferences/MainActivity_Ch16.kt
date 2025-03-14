package com.learning.talentprogramming.Ch_16_SharedPreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityMainCh16Binding
import com.learning.talentprogramming.databinding.ActivitySplashCh16Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity_Ch16 : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var binding : ActivityMainCh16Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCh16Binding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences("MY_PREF", MODE_PRIVATE)
        binding.apply {
            setContentView(root)
            btLogout.setOnClickListener {
                val editor = sharedPreferences.edit()
                editor.putBoolean("isUserLoggedIn", false)
                editor.apply()
                startActivity(Intent(this@MainActivity_Ch16, LoginActivity_Ch16::class.java))
                finish()
            }
        }

    }
}