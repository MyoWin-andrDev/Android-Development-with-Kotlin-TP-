package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.database

import android.content.Context
import androidx.room.Room

object StudentDBInstance {
    fun getDatabaseInstance(context : Context) = Room.databaseBuilder(context, StudentDb::class.java, "student.db").build()
}