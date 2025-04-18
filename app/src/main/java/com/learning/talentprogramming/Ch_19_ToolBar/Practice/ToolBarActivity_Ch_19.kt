package com.learning.talentprogramming.Ch_19_ToolBar.Practice

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.myUtilities.showToast
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityToolBarCh19Binding

class ToolBarActivity_Ch_19 : AppCompatActivity() {
    private lateinit var binding : ActivityToolBarCh19Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolBarCh19Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setSupportActionBar(toolbar)
            actionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.navigationIcon?.setColorFilter(getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_copy -> showToast("ToolBar Copy")
        }
        return super.onOptionsItemSelected(item)
    }
}