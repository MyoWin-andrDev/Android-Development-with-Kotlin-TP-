package com.learning.talentprogramming.Ch_8_Navigation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityLoginCh9Binding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginCh9Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginCh9Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }
    private fun getData(){
        if(intent != null) {
            var etName = intent.getStringExtra("name")
            var etPassword = intent.getStringExtra("password")
            var etPhoneNumber = intent.getStringExtra("phoneNumber")
            var etAddress = intent.getStringExtra("address")

            binding.txtName.text = etName
            binding.txtPhoneNumber.text = etPhoneNumber
            binding.txtAddress.text = etAddress
        }
    }
}