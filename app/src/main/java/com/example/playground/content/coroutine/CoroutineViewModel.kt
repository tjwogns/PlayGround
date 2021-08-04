package com.example.playground.content.coroutine

import androidx.lifecycle.viewModelScope
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.*

class CoroutineViewModel: BaseViewModel() {

    fun ex1() {
        var result = false

        viewModelScope.launch {
            result = true
            println("!!! result 1 : $result !!!")
        }

        println("!!! result 2 : $result !!!")
    }

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
}