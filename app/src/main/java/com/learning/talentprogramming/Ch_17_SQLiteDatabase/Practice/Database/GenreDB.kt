package com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import com.learning.talentprogramming.Ch_17_SQLiteDatabase.Practice.model.GenreModel

@RequiresApi(Build.VERSION_CODES.P)
class GenreDB(context: Context) : SQLiteOpenHelper(context, "GENRE_DB",  null, 1) {
    val TBL_GENRE = "tbl_genre"
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL("""CREATE TABLE $TBL_GENRE (g_id INTEGER PRIMARY KEY AUTOINCREMENT, g_name TEXT )""")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertGenre(genreName : String) : Boolean {
        val db = this@GenreDB.writableDatabase
        val cv = ContentValues()
        cv.put("g_name", genreName)
        try {
            db.insert(TBL_GENRE, null, cv)
            db.close()
            return true
        }catch (e : Exception){
            db.close()
            return false
        }
    }

    @SuppressLint("Range")
    fun getAllGenre() : List<GenreModel>{
        val genreList = ArrayList<GenreModel>()
        val db = this@GenreDB.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TBL_GENRE",null)
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast){
                genreList.add(GenreModel(
                    cursor.getInt(cursor.getColumnIndex("g_id")),
                    cursor.getString(cursor.getColumnIndex("g_name"))
                ))
                cursor.moveToNext()
            }
        }
        cursor.close()
        db.close()
        return genreList
    }

    fun updateGenre(genreId : Int ,genreName : String) : Boolean{
        val db = this@GenreDB.writableDatabase
        val cv = ContentValues()
        cv.put("g_name", genreName)
        try {
            db.update(TBL_GENRE, cv, "g_id = $genreId", null)
            db.close()
            return true
        }catch (e : Exception){
            db.close()
            return false
        }
    }

    fun deleteGenre(genreId : Int){
        val db = this@GenreDB.writableDatabase
        try {
            db.delete(TBL_GENRE, "g_id = $genreId", null)
            db.close()
        }catch(_ : Exception) {
            db.close()
        }
    }
}