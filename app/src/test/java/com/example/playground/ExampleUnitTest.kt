package com.example.playground

import android.net.Uri
import org.junit.Test

import org.junit.Assert.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun date_test() {
        val data = "2023-03-236T00:00:00+08:27Z"
        val suspendEndDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(data)

        val a = Date().toString()
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(a)

        suspendEndDate?.let {
            val result = it >= today
            println("!!! DEBUG !!! today[$today]")
            println("!!! DEBUG !!! result[$result]")

        }

    }

    @Test
    fun date_test2() {
        val data = "2023-03-236T00:00:00+08:27Z"
        val suspendEndDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(data)

        val a = Date()

        suspendEndDate?.let {
            val result = it >= a
            println("!!! DEBUG !!! a[$a]")
            println("!!! DEBUG !!! result[$result]")

        }

        val cal = Calendar.getInstance()
        val dateFormatter = DateFormat.getDateInstance(DateFormat.LONG)
        dateFormatter.timeZone = cal.timeZone

        val dateString = dateFormatter.format(suspendEndDate!!)
        println("!!! DEBUG !!! dateString[$dateString]")


    }

    @Test
    fun test3_string() {
        val test1 = "en"
        val test2 = "en-us"

        val result1 = test1.split("-").firstOrNull()
        val result2 = test2.split("-").firstOrNull()

        println("!!! DEBUG !!! result1 [$result1]")
        println("!!! DEBUG !!! result2 [$result2]")
    }

    @Test
    fun test4_url() {
//        val test = "https://www.jerry.com"
//        val test2 = "https://www.jerry.com?iframe=Y"
//        val uri1 = Uri.parse(test)
//        val uri2 = Uri.parse(test2)
//
//        val result = uri1.getQueryParameter("iframe")
//        val result2 = uri2.getQueryParameter("iframe")
//
//        println("!!! DEBUG !!! result[$result]")
//        println("!!! DEBUG !!! result2[$result2]")
    }
}