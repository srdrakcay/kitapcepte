package com.kitapcepte

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.flow.Flow
import kotlinx.flow.map

// Context üzerinden DataStore delegasyonunu tanımlıyoruz
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class UserPreferencesRepository(private val context: Context) {

    companion object {
        private val IS_USER_LOGGED_IN = booleanPreferencesKey("is_user_logged_in")
        private val USER_NAME = stringPreferencesKey("user_name")
    }

    // Kullanıcının giriş yapıp yapmadığını kontrol eden akış (Flow)
    val isUserLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[IS_USER_LOGGED_IN] ?: false
        }

    // Kullanıcı durumunu kaydetmek için fonksiyon
    suspend fun setUserLoggedIn(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_USER_LOGGED_IN] = isLoggedIn
        }
    }

    // Kullanıcı adını kaydetmek için fonksiyon
    suspend fun saveUsername(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = name
        }
    }
}

