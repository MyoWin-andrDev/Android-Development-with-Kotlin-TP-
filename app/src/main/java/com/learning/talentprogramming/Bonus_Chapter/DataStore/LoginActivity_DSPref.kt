package com.learning.talentprogramming.Bonus_Chapter.DataStore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.databinding.ActivityLoginCh16Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity_DSPref : AppCompatActivity() {
        private lateinit var dataStore: DataStorePref
        private lateinit var binding : ActivityLoginCh16Binding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityLoginCh16Binding.inflate(layoutInflater)
            dataStore = DataStorePref(this.application)
            binding.apply {
                setContentView(root)
                btLogin.setOnClickListener {
                    CoroutineScope(Dispatchers.Main).launch {
                        dataStore.saveIsUserLoggedIn(true)
                        startActivity(Intent(this@LoginActivity_DSPref, MainActivity_DSPref::class.java))
                        finish()
                    }
                }
            }
        }
}