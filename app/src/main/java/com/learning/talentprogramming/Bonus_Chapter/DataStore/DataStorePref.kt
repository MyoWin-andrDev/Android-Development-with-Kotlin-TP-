package com.learning.talentprogramming.Bonus_Chapter.DataStore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePref (private val application: Application) {
    companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("Data_Store_PREF")
        val IS_USER_LOGGED_IN = booleanPreferencesKey("isUserLoggedIn")
    }

    fun getIsUserLoggedIn() : Flow<Boolean?> = application.dataStore.data.map {
        it[IS_USER_LOGGED_IN] ?: false
    }

    suspend fun saveIsUserLoggedIn (isUserLoggedIn : Boolean){
        application.dataStore.edit {
            it[IS_USER_LOGGED_IN] = isUserLoggedIn
        }
    }
}