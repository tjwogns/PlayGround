package com.example.playground.content.flow

import androidx.lifecycle.viewModelScope
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class FlowViewModel: BaseViewModel() {

//    var baseData = getBaseFlow().asLiveData()
    ///////////////////////////////////////////////
    // <createByBuilder Result>
    ///////////////////////////////////////////////
    fun getBaseFlow(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i)
            println("!!! emit $i !!!")
            delay(100)
        }
    }

    val stateInFlow = getBaseFlow().stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = 0
        )


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

    fun ex6() {
        runBlocking {
            flowsWithZip()
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

    fun simple(): Flow<Int> = flow {
        println("Flow started")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }

    fun flowsAreCold() = runBlocking {
        println("Calling simple function...")
        val flow = simple()
        println("Calling collect...")
        flow.collect { value -> println(value) }
        println("Calling collect again...")
        flow.collect { value -> println(value) }
    }

    suspend fun flowsWithZip() {
        val nums = (1..3).asFlow().onEach { delay(300) } // numbers 1..3 every 300 ms
        val strs = flowOf("one", "two", "three").onEach { delay(400) } // strings every 400 ms
        val startTime = System.currentTimeMillis() // remember the start time
        nums.zip(strs) { a, b -> "$a -> $b" } // compose a single string with "zip"
            .collect { value -> // collect and print
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
    }
}