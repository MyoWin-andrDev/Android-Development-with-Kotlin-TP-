package com.learning.talentprogramming.Ch_10_ActivityLifeCycle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.R

class MainActivity_Ch10_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_ch10_1)
        Log.e("Testing", "SA : onCreate()")
        val button = findViewById<Button>(R.id.btnFinish)
        button.setOnClickListener(){
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e("Testing", "SA : onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Testing", "SA : onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Testing", "SA : onRestart()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Testing", "SA : onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Testing", "SA : onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Testing", "SA : onDestroy()")
    }
}