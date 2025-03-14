package com.learning.talentprogramming.Bonus_Chapter.DataStore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learning.talentprogramming.databinding.ActivitySplashCh16Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashScreen_DSPref : AppCompatActivity() {
    private lateinit var dataStore : DataStorePref
    private lateinit var binding : ActivitySplashCh16Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashCh16Binding.inflate(layoutInflater)
        dataStore = DataStorePref(this.application)
        binding.apply {
            setContentView(root)

            CoroutineScope(Dispatchers.Main).launch {
                val isUserLoggedIn = dataStore.getIsUserLoggedIn().first()
                delay(3000L)
                isUserLoggedIn?.let {
                    val activity = if (it) MainActivity_DSPref::class.java else LoginActivity_DSPref::class.java
                    startActivity(Intent(this@SplashScreen_DSPref, activity))
                    finish()
                }
            }
        }
    }
}