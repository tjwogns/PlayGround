package com.example.playground.content.flow

import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import androidx.core.os.ConfigurationCompat
import androidx.lifecycle.asLiveData
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.util.*

class FlowViewModel: BaseViewModel() {

    var baseData = getBaseFlow().asLiveData()
    ///////////////////////////////////////////////
    // <createByBuilder Result>
    ///////////////////////////////////////////////
    fun getBaseFlow(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i)
            println("println : $i")
        }
    }

    fun ex1() {
        runBlocking {
            val values = getValue()
            for (value in values) {
                println(value)
            }
        }
    }

    fun ex2() {
        runBlocking {
            val values = getValue2()
            for (value in values) {
                println(value)
            }
        }
    }

    fun ex3() {
        runBlocking {
            namesFlow
                .map { name -> name.length }
                .filter { length -> length < 5 }

            println()
        }
    }

    fun ex4() {
        runBlocking {
            namesFlow
                .map { name -> name.length }
                .filter { length -> length < 5 }
                .collect { println(it) }

            println()
        }
    }

    suspend fun getValue(): List<Int> {
        delay(1000)
        return listOf(1,2,3)
    }

    suspend fun getValue2(): Sequence<Int> = sequence {
        Thread.sleep(250)
        yield(1)
        Thread.sleep(250)
        yield(2)
        Thread.sleep(250)
        yield(3)
    }

    val namesFlow = flow {
        val names = listOf("Jody", "Steve", "Lance", "Joe")
        for (name in names) {
            delay(100)
            emit(name)
        }
    }
}