package com.learning.talentprogramming.Ch_18_ActionBar.Homework

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.Ch_18_ActionBar.Homework.myUtil.showToast
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityHomeCh18ActionBarBinding

class HomeActivity_Ch18_ActionBar : AppCompatActivity() {
    private lateinit var binding : ActivityHomeCh18ActionBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeCh18ActionBarBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            val actionBar = supportActionBar
            actionBar?.apply {
                title = "Welcome!!!"
            }
            btAdd.setOnClickListener {
                Intent(this@HomeActivity_Ch18_ActionBar, AddStudentActivity_Ch18_ActionBar::class.java).also {
                    startActivity(it)
                }
            }
            btEnquiry.setOnClickListener {
                Intent(this@HomeActivity_Ch18_ActionBar, StudentEnquiryActivity_Ch18_ActionBar::class.java).also {
                    startActivity(it)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_copy -> showToast("Copy Clicked")
            R.id.menu_edit-> showToast("Edit Clicked")
            R.id.menu_delete -> showToast("Delete Clicked")
            R.id.menu_add -> showToast("Add Clicked")
        }
        return super.onOptionsItemSelected(item)
    }
}