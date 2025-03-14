package com.learning.talentprogramming.Ch_16_SharedPreferences

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MyDataStore(private val application: Application){
    companion object {
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("isUserLoggedIn")
        val IS_USER_LOGGED_IN = booleanPreferencesKey("isUserLoggedIn")
    }

    fun isUserLoggedIn() : Flow<Boolean?> =
        application.datastore.data.map {
            it[IS_USER_LOGGED_IN] ?: false
        }

    suspend fun saveIsUserLoggedIn( isUserLoggedIn : Boolean){
        application.datastore.edit {
            it[IS_USER_LOGGED_IN] = isUserLoggedIn
        }
    }

}