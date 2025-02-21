package com.learning.talentprogramming.Ch_10_ActivityLifeCycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.R

class MainActivity_Ch10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ch10)
        Log.e("Testing", "MA : onCreate()")
        val button = findViewById<Button>(R.id.btn)
        button.setOnClickListener(){
            val intent = Intent(this@MainActivity_Ch10, MainActivity_Ch10_1::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("Testing", "MA : onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Testing", "MA : onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Testing", "MA : onRestart()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Testing", "MA : onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Testing", "MA : onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Testing", "MA : onDestroy()")
    }
}