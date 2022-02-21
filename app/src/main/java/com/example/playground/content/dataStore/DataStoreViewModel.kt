package com.example.playground.content.dataStore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.asLiveData
import com.example.playground.AppBase.Companion.appContext
import com.example.playground.ExampleInfo
import com.example.playground.dataStore
import com.example.playground.protoDataStore
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.IOException

class DataStoreViewModel: BaseViewModel() {

    private val prefDataStore = appContext.dataStore
    private val protoDataStore = appContext.protoDataStore

    // Preferences DataStore
    private val getIsBooleanFlow: Flow<Boolean> = prefDataStore.data.map { preferences ->
        preferences[IS_BOOLEAN_KEY] ?: false
    }

    var booleanData = getIsBooleanFlow.asLiveData()

    fun setIsBoolean(value: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            prefDataStore.edit { preferences ->
                preferences[IS_BOOLEAN_KEY] = value
            }
        }
    }

    // Proto DataStore
    private val getExampleInfo: Flow<ExampleInfo> = protoDataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(ExampleInfo.getDefaultInstance())
            } else {
                throw exception
            }

        }


    var protoInfoData = getExampleInfo.asLiveData()

    fun setExampleInfo(name: String, number: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            protoDataStore.updateData { currentInfo ->
                currentInfo.toBuilder()
                    .setName(name)
                    .setNumber(number)
                    .build()
            }
        }
    }

    companion object {
        val IS_BOOLEAN_KEY = booleanPreferencesKey("is_boolean_key")
    }
}