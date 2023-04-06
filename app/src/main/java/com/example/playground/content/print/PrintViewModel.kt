package com.example.playground.content.print

import com.example.playground.content.til.copy.Box
import com.example.playground.content.til.copy.Player
import com.tjwogns.presentation.base.BaseViewModel
import org.jsoup.Jsoup
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class PrintViewModel: BaseViewModel() {

    fun parse(): String? {

        val accessTokenRequestUrl = ""

        var accessToken: String? = null

        val ex = Executors.newSingleThreadExecutor().submit {

            accessToken = try {
                val url = URL(accessTokenRequestUrl)
                val doc = Jsoup.parse(url, 10000)

                val body = doc.body().text()

                if (!body.isNullOrEmpty()) {
                    body
                } else {
                    throw Exception("access token is null")
                }
            } catch (e: Exception) {
                null
            }
        }
        ex.get(10, TimeUnit.SECONDS)

        return accessToken
    }


    fun copyTest() {
//        val player1 = Player(7, "Son", "FW", Box(10))
    }
}