package com.example.playground.content.dataStore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.asLiveData
import com.example.playground.AppBase
import com.example.playground.AppBase.Companion.appContext
import com.example.playground.dataStore
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreViewModel: BaseViewModel() {

    private val dataStore = appContext.dataStore

    private val getIsBooleanFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_BOOLEAN_KEY] ?: false
    }

    var booleanData = getIsBooleanFlow.asLiveData()

    fun setIsBoolean(value: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.edit { preferences ->
                preferences[IS_BOOLEAN_KEY] = value
            }
        }
    }

    companion object {
        val IS_BOOLEAN_KEY = booleanPreferencesKey("is_boolean_key")
    }
}