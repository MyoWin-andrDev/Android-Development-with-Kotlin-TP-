//package com.learning.talentprogramming.Bonus_Chapter.RoomDatabase.DAO
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import androidx.room.Update
//import com.learning.talentprogramming.Bonus_Chapter.RoomDatabase.Entity.GenreEntity
//
//@Dao
//interface GenreDAO {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertGenre(genre : GenreEntity)
//    @Update
//    suspend fun updateGenre(genre : GenreEntity) : Int
//    @Delete
//    suspend fun deleteGenre(genre : GenreEntity)
//    @Query("SELECT * FROM tbl_genre")
//    suspend fun getALlGenre() : List<GenreEntity>
//}