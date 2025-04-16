@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.database.StudentDBInstance
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.database.StudentDb
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.entity.StudentModel
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.myUtil.showToast
import com.learning.talentprogramming.databinding.ActivityAddEditRoomCh17Binding
import kotlinx.coroutines.launch

class Add_EditActivity_Room_Ch17 : AppCompatActivity() {
    private lateinit var binding : ActivityAddEditRoomCh17Binding
    private lateinit var studentDB : StudentDb
    private var student : StudentModel? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditRoomCh17Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            studentDB = StudentDBInstance.getDatabaseInstance(this@Add_EditActivity_Room_Ch17)
            student = intent.getSerializableExtra("STUDENT_DATA") as? StudentModel

            if (student != null) {
                tvTitle.text = "Edit Student"
                populateFields()
            } else {
                tvTitle.text = "Add Student"
            }
            binding.btnSave.setOnClickListener {
                if (validateFields()) {
                    saveStudent()
                }
            }
        }
    }

    private fun populateFields() {
        student?.let {
            binding.etName.setText(it.name)
            binding.etGrade.setText(it.grade)
            binding.etRoomNo.setText(it.room)
            binding.etGender.setText(it.gender)
            binding.etFatherName.setText(it.fatherName)
        }
    }

    private fun validateFields(): Boolean {
        if (binding.etName.text.toString().trim().isEmpty()) {
            binding.etName.error = "Name required"
            return false
        }
        if (binding.etGrade.text.toString().trim().isEmpty()) {
            binding.etGrade.error = "Grade required"
            return false
        }
        if (binding.etRoomNo.text.toString().trim().isEmpty()) {
            binding.etRoomNo.error = "Room No required"
            return false
        }
        if (binding.etGender.text.toString().trim().isEmpty()) {
            binding.etGender.error = "Gender required"
            return false
        }
        if (binding.etFatherName.text.toString().trim().isEmpty()) {
            binding.etFatherName.error = "Father's name required"
            return false
        }
        return true
    }

    private fun saveStudent() {
        binding.apply {
            val newStudentRecord = StudentModel(
                name = etName.text.toString().trim(),
                grade = etGrade.text.toString().trim(),
                room = etRoomNo.text.toString().trim(),
                gender = etGender.text.toString().trim(),
                fatherName = etFatherName.text.toString().trim()
            )
            lifecycleScope.launch {
                if (student == null) {
                    if(studentDB.getStudentDAO().addStudent(newStudentRecord) > 0){
                        showToast("${newStudentRecord.name}'s Record Added")
                    }
                } else {
                    if(studentDB.getStudentDAO().updateStudent(newStudentRecord.id, newStudentRecord.name , newStudentRecord.grade, newStudentRecord.room, newStudentRecord.gender, newStudentRecord.fatherName) > 0){
                        showToast("${newStudentRecord.name}'s Record Updated")
                    }
                }
            }
            finish()
        }
    }
}