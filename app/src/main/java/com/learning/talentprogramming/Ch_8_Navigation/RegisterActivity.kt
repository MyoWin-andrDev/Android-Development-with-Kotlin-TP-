package com.learning.talentprogramming.Ch_8_Navigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.databinding.ActivityRegisterCh8Binding


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterCh8Binding
    private var etName = ""
    private var etPassword = ""
    private var etPhoneNumber = ""
    private var etAddress = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterCh8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }
    private fun onClick(){
        binding.btn.setOnClickListener() {
            etName = binding.etName.text.toString()
            etPassword = binding.etPassword.text.toString()
            etPhoneNumber = binding.etPhoneNumber.text.toString()
            etAddress = binding.etAddress.text.toString()
            toLoginIntent()
        }
    }
    private fun toLoginIntent(){
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        intent.putExtra("name", etName)
        intent.putExtra("password", etPassword)
        intent.putExtra("phoneNumber", etPhoneNumber)
        intent.putExtra("address", etAddress)
        startActivity(intent)
    }
}