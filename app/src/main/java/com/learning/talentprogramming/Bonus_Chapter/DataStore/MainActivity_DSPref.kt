package com.learning.talentprogramming.Bonus_Chapter.DataStore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learning.talentprogramming.databinding.ActivityMainCh16Binding
import kotlinx.coroutines.launch

class MainActivity_DSPref : AppCompatActivity() {
        private lateinit var dataStore : DataStorePref
        private lateinit var binding : ActivityMainCh16Binding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainCh16Binding.inflate(layoutInflater)
            dataStore = DataStorePref(this.application)
            binding.apply {
                setContentView(root)
                btLogout.setOnClickListener {
                    //Practicing LifeCycleScope On Purpose
                    lifecycleScope.launch {
                        dataStore.saveIsUserLoggedIn(false)
                        startActivity(Intent(this@MainActivity_DSPref, LoginActivity_DSPref::class.java))
                        finish()
                    }
                }
            }
        }
}