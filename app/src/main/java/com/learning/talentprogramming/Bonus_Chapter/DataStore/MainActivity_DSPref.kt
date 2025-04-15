package com.learning.talentprogramming.Bonus_Chapter.DataStore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.databinding.ActivityMainCh16Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity_DSPref : AppCompatActivity() {
    private lateinit var dataStore: DataStore
    private lateinit var binding : ActivityMainCh16Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCh16Binding.inflate(layoutInflater)
        dataStore = DataStore(application)
        binding.apply {
            setContentView(root)
            btLogout.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    dataStore.saveIsUserLoggedIn(false)
                    Intent(this@MainActivity_DSPref, LoginActivity_DSPref::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }
        }
    }
}