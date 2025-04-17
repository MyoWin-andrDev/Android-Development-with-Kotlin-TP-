package com.learning.talentprogramming.Ch_19_ToolBar.Homework.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityAddStudentCh19ToolbarBinding

class AddStudentActivity_Ch_19_Toolbar : AppCompatActivity() {
    private lateinit var binding : ActivityAddStudentCh19ToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentCh19ToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tbToolbar.tbLayout.apply {
            title = "Add Student"
            setTitleTextColor(getColor(R.color.md_theme_onPrimary))
            setNavigationIcon(R.drawable.ic_back)
            setNavigationIconTint(getColor(R.color.md_theme_onPrimary))
            setNavigationOnClickListener { onBackPressed() }
        }
    }
}