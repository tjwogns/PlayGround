package com.example.playground.content.dateTime

import android.text.format.DateFormat
import com.tjwogns.presentation.base.BaseViewModel
import java.text.SimpleDateFormat
import java.util.*

class DateTimeViewModel: BaseViewModel() {

    fun ex1() {
        //2022-10-07T04:09:36Z

        val targetDatelist = listOf(
            "2022-10-07T00:00:00Z",
            "2022-10-07T01:09:36Z",
            "2022-10-07T02:09:36Z",
            "2022-10-07T03:09:36Z",
            "2022-10-07T04:09:36Z",
            "2022-10-07T05:09:36Z",
            "2022-10-07T06:09:36Z",
            "2022-10-07T07:09:36Z",
            "2022-10-07T08:09:36Z",
            "2022-10-07T09:09:36Z",
            "2022-10-07T10:09:36Z",
            "2022-10-07T11:09:36Z",
            "2022-10-07T12:09:36Z",
            "2022-10-07T13:09:36Z",
            "2022-10-07T14:09:36Z",
            "2022-10-07T15:09:36Z",
            "2022-10-07T16:09:36Z",
            "2022-10-07T17:09:36Z",
            "2022-10-07T18:09:36Z",
            "2022-10-07T19:09:36Z",
            "2022-10-07T20:09:36Z",
            "2022-10-07T21:09:36Z",
            "2022-10-07T22:09:36Z",
            "2022-10-07T23:09:36Z",
            "2022-10-07T24:00:00Z",
        )


        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        date.timeZone = TimeZone.getTimeZone("UTC")

        targetDatelist.forEachIndexed { index, s ->
            val x = date.parse(s)
            val registrationDateStr = DateFormat.format("yyyy.MM.dd", x).toString()
            val m = x.time
            println("!!! TEST !!! localDate ${index}시 [${registrationDateStr}] [$x] [$m]")
        }

    }
}