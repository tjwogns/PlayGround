package com.example.playground.content.locale

import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import androidx.core.os.ConfigurationCompat
import com.tjwogns.presentation.base.BaseViewModel
import java.util.*

class LocaleViewModel: BaseViewModel() {

    ///////////////////////////////////////////////
    // <createByBuilder Result>
    // locale : ko_KR
    ///////////////////////////////////////////////
    fun createByBuilder() {
        val locale = Locale.Builder()
            .setLanguage("ko")
            .setRegion("KR")
            .build()

        println("locale : $locale")
    }

    ///////////////////////////////////////////////
    // <createByConstructor Result>
    // locale : ko_KR
    ///////////////////////////////////////////////
    fun createByConstructor() {
        val locale = Locale("ko","KR")

        println("locale : $locale")
    }

    ///////////////////////////////////////////////
    // <createByFactoryMethod Result>
    // locale : ko_KR
    // locale.language : ko
    // locale.country : KR
    ///////////////////////////////////////////////
    fun createByFactoryMethod() {
        val locale = Locale.forLanguageTag("ko-KR")

        println("locale : $locale")
        println("locale.language : ${locale.language}")
        println("locale.country : ${locale.country}")
    }

    ///////////////////////////////////////////////
    // <createByConstants Result>
    // locale : ko_KR
    // locale.language : ko
    // locale.country : KR
    // locale2 : ko
    // locale2.language : ko
    // locale2.country :
    ///////////////////////////////////////////////
    fun createByConstants() {
        val locale = Locale.KOREA

        println("locale : $locale")
        println("locale.language : ${locale.language}")
        println("locale.country : ${locale.country}")

        val locale2 = Locale.KOREAN

        println("locale2 : $locale2")
        println("locale2.language : ${locale2.language}")
        println("locale2.country : ${locale2.country}")
    }

    ///////////////////////////////////////////////
    // <getLanguage Result>
    // locale.displayLanguage : Korean
    // locale.getDisplayLanguage : 한국어
    // locale.language : ko
    // locale.isO3Language : kor
    ///////////////////////////////////////////////
    fun getLanguage() {
        val locale = Locale.KOREA

        println("locale.displayLanguage : ${locale.displayLanguage}")
        println("locale.getDisplayLanguage : ${locale.getDisplayLanguage(Locale.KOREA)}")
        println("locale.language : ${locale.language}")
        println("locale.isO3Language : ${locale.isO3Language}")
    }

    ///////////////////////////////////////////////
    // <getCountry Result>
    // locale.displayCountry : South Korea
    // locale.getDisplayCountry : 대한민국
    // locale.country : KR
    // locale.isO3Country : KOR
    ///////////////////////////////////////////////
    fun getCountry() {
        val locale = Locale.KOREA

        println("locale.displayCountry : ${locale.displayCountry}")
        println("locale.getDisplayCountry : ${locale.getDisplayCountry(Locale.KOREA)}")
        println("locale.country : ${locale.country}")
        println("locale.isO3Country : ${locale.isO3Country}")
    }

    ///////////////////////////////////////////////
    // <getDefault Result>
    // defaultLocale before : en_US
    // defaultLocale after : ko_KR
    ///////////////////////////////////////////////
    fun getDefault() {
        // Default Locale of your application
        val defaultLocale = Locale.getDefault()
        println("defaultLocale before : $defaultLocale")

        Locale.setDefault(Locale.KOREA)
        val defaultLocale2 = Locale.getDefault()
        println("defaultLocale after : $defaultLocale2")
    }

    ///////////////////////////////////////////////
    // <getDeviceLocale Result>
    // deviceLocale : en_US
    // deviceLocaleList[0] : en_US
    // deviceLocaleList[1] : ko_KR
    // deviceLocale2 : en_US
    // deviceLocaleList2[0] : en_US
    // deviceLocaleList2[1] : ko_KR
    ///////////////////////////////////////////////
    fun getDeviceLocale() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Since API 24
            val deviceLocale = Resources.getSystem().configuration.locales[0]

            println("deviceLocale : $deviceLocale")

            val deviceLocaleList = LocaleList.getDefault()
            for (i in 0 until deviceLocaleList.size()) {
                println("deviceLocaleList[$i] : ${deviceLocaleList[i]}")
            }
        }

        val deviceLocale2 = ConfigurationCompat.getLocales(Resources.getSystem().configuration)[0] // Compat method
        println("deviceLocale2 : $deviceLocale2")


        val deviceLocaleList2 = ConfigurationCompat.getLocales(Resources.getSystem().configuration) // Compat method
        for (i in 0 until deviceLocaleList2.size()) {
            println("deviceLocaleList2[$i] : ${deviceLocaleList2[i]}")
        }
    }
}