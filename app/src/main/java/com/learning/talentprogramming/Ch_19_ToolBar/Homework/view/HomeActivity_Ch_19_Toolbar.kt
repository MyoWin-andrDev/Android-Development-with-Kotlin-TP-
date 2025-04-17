package com.learning.talentprogramming.Ch_19_ToolBar.Homework.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.myUtil.showToast
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityHomeCh19ToolbarBinding

class HomeActivity_Ch_19_Toolbar : AppCompatActivity() {
    private lateinit var binding : ActivityHomeCh19ToolbarBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeCh19ToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tbToolbar.tbLayout.apply {
            title = "Welcome!!!"
            setTitleTextColor(getColor(R.color.md_theme_onPrimary))
            inflateMenu(R.menu.menu_item)
            overflowIcon?.setColorFilter(getColor(R.color.md_theme_onPrimary), PorterDuff.Mode.SRC_ATOP)
            setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_copy -> showToast("Copy Clicked")
                    R.id.menu_edit -> showToast("Edit Clicked")
                    R.id.menu_delete -> showToast("Delete Clicked")
                    R.id.menu_add -> showToast("Add Clicked")
                }
                true
            }
        }
        binding.apply {
            btAdd.setOnClickListener {
                Intent(this@HomeActivity_Ch_19_Toolbar, AddStudentActivity_Ch_19_Toolbar::class.java).also{
                    startActivity(it)
                }
            }
            btEnquiry.setOnClickListener {
                Intent(this@HomeActivity_Ch_19_Toolbar, StudentEnquiryActivity_Ch_19_Toolbar::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}