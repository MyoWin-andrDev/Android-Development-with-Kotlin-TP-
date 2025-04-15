package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Homework.model.Student
import com.learning.talentprogramming.databinding.ListItemStudentBinding

class StudentAdapter(private var studentList :List<Student>, private val onDeleteClick : (Student) -> Unit, private val onItemLongClick : (Student) -> Unit) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class  StudentViewHolder(val binding : ListItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(ListItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = studentList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateStudent(newStudentList : List<Student>){
        this.studentList = newStudentList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {
            val student = studentList[position]
            tvName.text = student.s_name
            tvStudentId.text = student.s_id.toString()
            tvGrade.text = student.s_grade
            tvRoom.text = student.s_room
            btnDelete.setOnClickListener {
                onDeleteClick(student)
            }
            root.setOnLongClickListener {
                onItemLongClick(student)
                true
            }
        }
    }
}