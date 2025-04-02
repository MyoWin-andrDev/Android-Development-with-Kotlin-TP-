package com.learning.talentprogramming.Ch_18_ActionBar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.myUtilities.showToast
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityActionBarCh18Binding

class ActionBarActivity_Ch18 : AppCompatActivity() {
    private lateinit var binding : ActivityActionBarCh18Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionBarCh18Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.let {
            it.apply {
                title = "   Title"
                subtitle = "    Subtitle"
                setIcon(R.drawable.ic_heart)
                setDisplayUseLogoEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.men_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_copy -> startActivity(Intent(this@ActionBarActivity_Ch18, SecondActivity_Ch18::class.java))
            R.id.menu_edit -> showToast("Edit Clicked")
            R.id.menu_delete -> showToast("Delete Clicked")
        }
        return super.onOptionsItemSelected(item)
    }
}