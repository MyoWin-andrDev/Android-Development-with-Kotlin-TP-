package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.entity.StudentModel
import com.learning.talentprogramming.databinding.ListItemStudentBinding

class StudentAdapterRoom (private var studentList :List<StudentModel>, private val onDeleteClick : (StudentModel) -> Unit, private val onItemLongClick : (StudentModel) -> Unit) : RecyclerView.Adapter<StudentAdapterRoom.StudentViewHolder>() {

    inner class  StudentViewHolder(val binding : ListItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(ListItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = studentList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateStudent(newStudentList : List<StudentModel>){
        this.studentList = newStudentList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {
            val student = studentList[position]
            tvStudentId.text = student.id.toString()
            tvName.text = student.name
            tvGrade.text = student.grade
            tvRoom.text = student.room
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