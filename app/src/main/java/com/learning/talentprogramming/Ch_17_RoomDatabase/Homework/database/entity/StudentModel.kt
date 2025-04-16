package com.learning.talentprogramming.Ch_17_RoomDatabase.Homework.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("tbl_student")
data class StudentModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("s_id")
    val id : Int ? = 0,
    @ColumnInfo("s_name")
    val name : String,
    @ColumnInfo("s_grade")
    val grade : String,
    @ColumnInfo("s_room")
    val room : String,
    @ColumnInfo("s_gender")
    val gender: String,
    @ColumnInfo("s_fatherName")
    val fatherName : String
) : Serializable