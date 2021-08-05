package com.example.playground.content.coroutine

import androidx.lifecycle.viewModelScope
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.*

class CoroutineViewModel: BaseViewModel() {

    fun dispatchers() {
        runBlocking {
            launch { // context of the parent, main runBlocking coroutine
                println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
                println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
                println("Default               : I'm working in thread ${Thread.currentThread().name}")
            }
            launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
            }
        }
    }

    ///////////////////////////////////////////////
    // <ex1 Result>
    //  !!! result 2 : false !!!
    //  !!! result 1 : true !!!
    ///////////////////////////////////////////////
    fun ex1() {
        var result = false

        CoroutineScope(Dispatchers.IO).launch {
            result = true
            println("!!! result 1 : $result !!!")
        }

        println("!!! result 2 : $result !!!")
    }

    ///////////////////////////////////////////////
    // <ex2 Result>
    //  !!! result 1 : true !!!
    //  !!! result 2 : true !!!
    ///////////////////////////////////////////////
    fun ex2() {
        var result = false

        viewModelScope.launch {

            val deferred = CoroutineScope(Dispatchers.IO).async {
                result = true
                println("!!! result 1 : $result !!!")
            }
            deferred.await()
            println("!!! result 2 : $result !!!")
        }

    }

    ///////////////////////////////////////////////
    // <ex3 Result>
    //  !!! result 2 : false !!!
    //  !!! result 1 : true !!!
    ///////////////////////////////////////////////
    fun ex3() {
        var result = false

        viewModelScope.launch {

            val deferred = CoroutineScope(Dispatchers.IO).async {
                result = true
                println("!!! result 1 : $result !!!")
            }
            println("!!! result 2 : $result !!!")
            deferred.await()
        }


    }

    ///////////////////////////////////////////////
    // <ex4 Result>
    //  !!! result 1 : true !!!
    //  !!! result 2 : true !!!
    ///////////////////////////////////////////////
    fun ex4() {
        var result = false

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                result = true
                println("!!! result 1 : $result !!!")
            }

            println("!!! result 2 : $result !!!")
        }

    }


    ///////////////////////////////////////////////
    // <ex5 Result>
    //  Hello
    //  World!
    ///////////////////////////////////////////////
    fun ex5() {
        runBlocking {
            launch {
                delay(100L)
                println("World!")
            }
            yield()
            println("Hello")
        }
    }
}