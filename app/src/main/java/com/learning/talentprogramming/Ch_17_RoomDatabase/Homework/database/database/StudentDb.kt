package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.dao.StudentDAO
import com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.entity.StudentModel

@Database(entities = [StudentModel::class], version = 1, exportSchema = false)
abstract class StudentDb : RoomDatabase() {
    abstract fun getStudentDAO() : StudentDAO
}