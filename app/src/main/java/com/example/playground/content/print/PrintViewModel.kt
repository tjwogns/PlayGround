package com.example.playground.content.print

import com.tjwogns.presentation.base.BaseViewModel
import org.jsoup.Jsoup
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class PrintViewModel: BaseViewModel() {

    fun parse() {

        val ex = Executors.newSingleThreadExecutor().submit {
            println("!!!! 0 !!!!")

            val aTokenRequestUrl = "https://www.mailplug.com/plug_api/atoken_get/mailplug"

            try {
                val url = URL(aTokenRequestUrl)
                val doc = Jsoup.parse(url, 10000)

                println("!!! doc.body().text() : ${doc.body().text()} !!!")



            } catch (e: Exception) {
                println("!!! xml parse failed !!!")
                println("!!! e : ${e.printStackTrace()} !!!")
            }
        }
        ex.get(10, TimeUnit.SECONDS)
    }


//    fun parse() {
//
//        val ex = Executors.newSingleThreadExecutor().submit {
//            println("!!!! 0 !!!!")
//
//            val aTokenRequestUrl = "https://www.mailplug.com/plug_api/atoken_get/mailplug"
//            try {
//
//                println("!!!! 1 !!!!")
//                val url = URL(aTokenRequestUrl)
//                println("!!!! 1-1 !!!!")
//
//                val xmlPullParserFactory = XmlPullParserFactory.newInstance()
//                val parser = xmlPullParserFactory.newPullParser()
//                println("!!!! 1-2 !!!!")
//
//                val inputStream = url.openStream()
//                parser.setInput(InputStreamReader(inputStream, Charsets.UTF_8.name()))
//                println("!!!! 1-3 !!!!")
//
//                var eventType = parser.eventType
//                println("!!!! 2 !!!!")
//
//                while (eventType != XmlPullParser.END_DOCUMENT) {
//                    println("!!!! 2 - 1 : $eventType !!!!")
//
//                    when (eventType) {
//                        XmlPullParser.START_TAG -> {
//                            println("!!! XmlPullParser.START_TAG START !!!")
//                            println("value : ${parser.text}")
//                            println("!!! XmlPullParser.START_TAG END !!!")
//                        }
//
//                        XmlPullParser.END_TAG -> {
//                            println("!!! XmlPullParser.END_TAG START !!!")
//                            println("value : ${parser.text}")
//                            println("!!! XmlPullParser.END_TAG END !!!")
//                        }
//
//                        XmlPullParser.TEXT -> {
//                            println("!!! XmlPullParser.TEXT START !!!")
//                            println("value : ${parser.text}")
//                            println("!!! XmlPullParser.TEXT END !!!")
//                        }
//                    }
//                    println("!!!! 2 - 2 : $eventType !!!!")
//                    eventType = parser.next()
//                    println("!!!! 2 - 3 : $eventType !!!!")
//                }
//
//
//            } catch (e: Exception) {
//                println("!!! xml parse failed !!!")
//                println("!!! e : ${e.printStackTrace()} !!!")
//            }
//        }
//        ex.get(10, TimeUnit.SECONDS)
//    }
}