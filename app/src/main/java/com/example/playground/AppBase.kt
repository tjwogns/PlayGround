package com.example.playground

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.playground.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppBase: Application() {


    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        startKoin {
            androidContext(applicationContext)
            modules(viewModelModule)
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferencesTest")
