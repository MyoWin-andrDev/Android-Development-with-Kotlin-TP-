package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.adapter.StudentAdapter
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.database.StudentDatabase
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.model.Student
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.myUtil.showToast
import com.learning.talentprogramming.R
import com.learning.talentprogramming.databinding.ActivityStudentCh17Binding

class StudentActivity_Ch17 : AppCompatActivity() {
    private lateinit var binding : ActivityStudentCh17Binding
    private lateinit var studentDB : StudentDatabase
    private lateinit var adapter : StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentCh17Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            studentDB = StudentDatabase(this@StudentActivity_Ch17)
            adapter = StudentAdapter(emptyList(),
                onDeleteClick = {student -> showDeleteConfirmation(student)},
                onItemLongClick = {student -> handleLongPressed(student)})
            rvStudent.adapter = adapter
            loadStudents()
            binding.fbAddStudent.setOnClickListener{
                Intent(this@StudentActivity_Ch17, Add_EditActivity_Ch17::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadStudents()
    }
    private fun loadStudents(){
        val studentList = studentDB.getAllStudents()
        adapter.updateStudent(studentList)
    }
    private fun showDeleteConfirmation(student: Student){
        AlertDialog.Builder(this)
            .setTitle("Delete")
            .setMessage("Are you sure to delete?")
            .setCancelable(true)
            .setPositiveButton("Delete"){_,_ ->
                if(studentDB.deleteStudent(student.s_id!!)) {
                    showToast("${student.s_name}'s records deleted successfully")
                }
                loadStudents()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun handleLongPressed(student : Student){
        Intent(this@StudentActivity_Ch17, Add_EditActivity_Ch17::class.java).also {
            it.putExtra("student",student)
            startActivity(it)
        }
    }
}