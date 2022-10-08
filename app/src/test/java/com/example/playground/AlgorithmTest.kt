package com.example.playground

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

    @Test
    fun test2() {
        val money = arrayListOf(1, 5, 10)
        dd(money.toTypedArray())

        println("!!! RESULT !!! ${money.toString()}")
    }

    fun dd(a: Array<Int>) {
        a[0] = 0
    }

    @Test
    fun algorithm08(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {
        var answer: Int = -1


        return answer
    }

    /**
     *  플레이어가 발판에서 이동할 수 있는 공간
     */
    fun movableLoc(board: Array<IntArray>, playerLoc: IntArray): Array<IntArray> {
        val playerMoveLoc = buildMovableDirection(intArrayOf(board[0].size, board.size), playerLoc)

        return playerMoveLoc.filter {
            val x = it[0]
            val y = it[1]

            board[x][y] == 1
        }.toTypedArray()

    }

    /**
     * 이동할 수 있는 방향
     */
    fun buildMovableDirection(boardSize: IntArray, playerLoc: IntArray): Array<IntArray> {
        val movableLoc = arrayListOf(
            intArrayOf(playerLoc[0]-1, playerLoc[1]),
            intArrayOf(playerLoc[0]+1, playerLoc[1]),
            intArrayOf(playerLoc[0], playerLoc[1]-1),
            intArrayOf(playerLoc[0], playerLoc[1]+1),
        )

        return movableLoc
            .asSequence()
            .filter { it[0] > -1 && it[0] < boardSize[0] }
            .filter { it[1] > -1 && it[1] < boardSize[1] }
            .toList().toTypedArray()

    }
}

