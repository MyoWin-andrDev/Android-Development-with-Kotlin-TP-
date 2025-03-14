package com.learning.talentprogramming.Bonus_Chapter.CoroutineScope

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learning.talentprogramming.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coroutine)

        //Should use for only professional , otherwise, memory leak will occur
        GlobalScope.launch {

        }

        //Easy to use , light weight thread
        //Every 1000 of CoroutineScope is equal to 1 Thread
        //Three Type of "Coroutine Dispatchers"
        //1. Dispatchers.Default (Used for default like CPU intensive.Eg. Retrieving value from huge data stored ArrayList)
        //2. Dispatchers.Main (Used for UI)
        //3. Dispatchers.IO (Used for background threads, like Network calls.Eg. API )
        //4. Dispatches.Unconfined (hardly ever used)
        CoroutineScope(Dispatchers.Unconfined).launch {

        }

        //LifeCycleScope
        //lifecycle scope is active until the application is running. And pause on onPause() state
        lifecycleScope.launch {

        }
    }
}