package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.adapter.StudentAdapterRoom
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.database.StudentDBInstance
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.database.StudentDb
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.entity.StudentModel
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.myUtil.showToast
import com.learning.talentprogramming.databinding.ActivityStudentRoomCh17Binding
import kotlinx.coroutines.launch

class StudentActivity_Room_Ch_17 : AppCompatActivity() {
    private lateinit var binding : ActivityStudentRoomCh17Binding
    private lateinit var studentDB : StudentDb
    private lateinit var adapter : StudentAdapterRoom
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRoomCh17Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            studentDB = StudentDBInstance.getDatabaseInstance(this@StudentActivity_Room_Ch_17)
            lifecycleScope.launch {
                adapter = StudentAdapterRoom(emptyList(),
                    onDeleteClick = {student -> showDeleteConfirmation(student)},
                    onItemLongClick = {student -> handleLongPressed(student)})
                rvStudent.adapter = adapter
                loadStudents()
            }
            binding.fbAddStudent.setOnClickListener{
                Intent(this@StudentActivity_Room_Ch_17, Add_EditActivity_Room_Ch17::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            loadStudents()
        }
    }
    private suspend fun loadStudents(){
        val studentList = studentDB.getStudentDAO().getAllStudent()
        adapter.updateStudent(studentList)
    }
    private fun showDeleteConfirmation(student: StudentModel){
        AlertDialog.Builder(this)
            .setTitle("Delete")
            .setMessage("Are you sure to delete?")
            .setCancelable(true)
            .setPositiveButton("Delete"){_,_ ->
                lifecycleScope.launch {
                    if(studentDB.getStudentDAO().deleteStudent(student.id!!) > 0){
                        showToast("${student.name}'s records deleted successfully")
                    }
                    loadStudents()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun handleLongPressed(student : StudentModel){
        Intent(this@StudentActivity_Room_Ch_17, Add_EditActivity_Room_Ch17::class.java).also {
            it.putExtra("STUDENT_DATA",student)
            startActivity(it)
        }
    }
}