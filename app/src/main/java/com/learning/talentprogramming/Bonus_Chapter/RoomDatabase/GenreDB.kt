package com.learning.talentprogramming.Bonus_Chapter.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learning.talentprogramming.Bonus_Chapter.RoomDatabase.DAO.GenreDAO
import com.learning.talentprogramming.Bonus_Chapter.RoomDatabase.Entity.GenreEntity

@Database(entities = [GenreEntity::class], version = 1, exportSchema = false)
abstract class GenreDB : RoomDatabase(){
    abstract fun getGenreDAO() : GenreDAO
}