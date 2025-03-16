package com.learning.talentprogramming.Bonus_Chapter.RoomDatabase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_genre")
data class GenreEntity(
    @PrimaryKey(autoGenerate = true)
    private val genreId : Int,
    @ColumnInfo
    private val genreName : String
)
