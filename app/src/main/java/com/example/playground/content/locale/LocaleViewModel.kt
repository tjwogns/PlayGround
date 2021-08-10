package com.example.playground.content.locale

import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import androidx.core.os.ConfigurationCompat
import androidx.lifecycle.viewModelScope
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.*
import java.util.*

class LocaleViewModel: BaseViewModel() {

    ///////////////////////////////////////////////
    // <createBuilder Result>
    // locale : ko_KR
    ///////////////////////////////////////////////
    fun createBuilder() {
        val locale = Locale.Builder()
            .setLanguage("ko")
            .setRegion("KR")
            .build()

        println("locale : $locale")
    }

    ///////////////////////////////////////////////
    // <ex1 Result>
    ///////////////////////////////////////////////
    fun ex1() {
        // Default Locale of your application
        val defaultLocale = Locale.getDefault()
        println("defaultLocale before : $defaultLocale")

        Locale.setDefault(Locale.KOREA)
        val defaultLocale2 = Locale.getDefault()
        println("defaultLocale after : $defaultLocale2")

        ///////////////////////////////////////////

        // Locale from a given IETF BCP 47 language tag
        val localeByTag = Locale.forLanguageTag("fr-CA")
        val localeFrCA = Locale("fr", "CA")

        println("localeByTag : $localeByTag")
        println("localeFrCA : $localeFrCA")

        // Used as the language/country neutral locale
        // for the locale sensitive operations
        val root = Locale.ROOT
        println("root : $root")

        // French language Locale without country restriction
        val fr = Locale.FRENCH
        println("fr : $fr")

        // French Locale for France
        val frFR = Locale.FRANCE
        println("frFR : $frFR")

        // First Locale of your device
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Since API 24
            val fLocale = Resources.getSystem().configuration.locales[0]

            println("fLocale : $fLocale")
        }
        val fLocale2 = ConfigurationCompat.getLocales(Resources.getSystem().configuration)[0] // Compat method
        println("fLocale2 : $fLocale2")


        // The application Locale + all device Locales
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Since API 24
            val list = LocaleList.getDefault()
            println("list size : ${list.size()}")

            for (i in 0 until list.size()) {
                println("list[$i] : ${list[i]}")
            }
        }

        // Create a Locale with Locale.Builder()
        val bLocale = Locale.Builder().setLanguage("sr").setScript("Latn").setRegion("RS").build()
        println("bLocale : $bLocale")
    }
}