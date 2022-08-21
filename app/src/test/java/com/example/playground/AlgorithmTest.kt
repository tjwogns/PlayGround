package com.example.playground

import org.junit.Assert
import org.junit.Test

class AlgorithmTest {
//    fun main(args: Array<String>) {
    /*
     * 22년 8월 22일
     * https://www.acmicpc.net/problem/11047
     * 시작 시간 :
     * 소요 시간 :
     */
    @Test
    fun algorithm_11047() {
        val nums = readLine()!!.split(" ")
        val n = nums[0].toInt()
        val k = nums[1].toInt()

        var money = mutableListOf<Int>()

        while (n > money.size) {
            val input = readlnOrNull()!!.toInt()

            money.add(input)
        }

        val answer = if (n == 0) 0 else algorithm_11047a(k, money.toTypedArray())
        println(answer)
    }

    fun algorithm_11047a(target: Int, moneys: Array<Int>): Int {

        // 필요 동전 갯수
        var count = 0

        var tempValue = target

        for (money in moneys.sortedArrayDescending()) {
            if (tempValue == 0) break

            val mok = tempValue / money

            if (mok == 0) continue
            count += mok
            tempValue -= money * mok
        }

        return count
    }



    @Test
    fun test() {
        val k = 4790
        val money = arrayListOf(1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000)
        val answer = algorithm_11047a(k, money.toTypedArray())

        println("!!! RESULT !!! $answer")
    }
}

