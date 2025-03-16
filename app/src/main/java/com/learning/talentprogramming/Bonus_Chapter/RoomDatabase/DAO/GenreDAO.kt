package com.learning.talentprogramming.Bonus_Chapter.RoomDatabase.DAO

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.model.GenreModel

@Dao
interface GenreDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genreModel: GenreModel)
    @Update
    fun updateGenre(genreModel: GenreModel)
    @Delete
    fun deleteGenre(genreModel: GenreModel)
    @Query("SELECT * FROM tbl_genre")
    fun getALlGenre() : List<GenreModel>
}