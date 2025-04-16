package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.entity.StudentModel

@Dao
interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student : StudentModel) : Long
    @Query("SELECT * FROM tbl_student")
    suspend fun getAllStudent() : List<StudentModel>
    @Query("UPDATE tbl_student SET s_name = :name, s_grade = :grade, s_room = :room , s_gender = :gender, s_fatherName = :fatherName WHERE s_id = :id")
    suspend fun updateStudent(id : Int?, name : String, grade : String, room : String, gender : String, fatherName : String ) : Int
    @Query("DELETE FROM tbl_student WHERE s_id = :id")
    suspend fun deleteStudent(id : Int) : Int
}