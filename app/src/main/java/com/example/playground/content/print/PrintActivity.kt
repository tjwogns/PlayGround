package com.example.playground.content.print

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityPrintBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PrintActivity : BaseActivity<ActivityPrintBinding, PrintViewModel>(
    R.layout.activity_print
) {

    override val viewModel: PrintViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() {
        binding.tvPrint1.setOnClickListener {
            printTest02()
        }

        binding.tvPrint2.setOnClickListener {
            val idList = arrayOf("muzi", "frodo", "apeach", "neo")
            val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
            val k = 2

//            val idList = arrayOf("con", "ryan")
//            val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
//            val k = 3

//            algorithm01(idList, report, k)
            algorithm01_01(idList, report, k)
        }

        binding.tvXmlParse.setOnClickListener {
            println("!!! START PARSE !!!")
            val atoken = viewModel.parse()
            println("!!! atoken : $atoken !!!")
            println("!!! END PARSE !!!")

        }
    }

    private fun printTest01() {
        val str = "abcdefgfff"
        val strSubstring = str.substring(0, 5)
        val strTake = str.take(5)

        println("!!! strSubstring : $strSubstring !!!")
        println("!!! strTake : $strTake !!!")

        val t = str.substring(1..(str.length-2))
        println("!!! DEBUG t : $t")

        val s = if (str.length >= 3) str.substring(1, str.length-2) else ""

        println("!!! DEBUG s : $s")
    }

    private fun printTest02() {
        var answer = 1
        val clothes: Array<Array<String>> = arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
        val clothesHash = HashMap<String, MutableList<String>>()

        clothes.forEach {
            if (clothesHash.containsKey(it[1])) {
                clothesHash[it[1]]?.add(it[0])
            } else {
                clothesHash[it[1]] = mutableListOf(it[0])
            }
        }

        clothesHash.keys.forEach { key ->
            println("!!! DEBUG key.size : ${(clothesHash[key]?.size)}")

            println("!!! DEBUG key.size + 1 : ${((clothesHash[key]?.size ?: 0) + 1)}")
            answer *= (clothesHash[key]?.size ?: 0 + 1)
        }

    }

    private fun printTest03() {
        var answer = 1
        val clothes: Array<Array<String>> = arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))

        answer = clothes.groupBy { it[1] }.values.fold(1) { total, v -> total * (v.size + 1) } - 1

    }

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/92334
     * 시작 시간 : 22.03.27 15:20
     * 소요 시간 : 2시간 정도 소요
     */
    private fun algorithm01(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        // report 2차 함수로으로 변환
        val reportLists = report.distinct().map { it.split(" ") }
        println("!!! reportLists : ${reportLists.toString()} !!!")

        // 1. 유저 마다 신고 당한 횟수
        val reportCounts = mutableMapOf<String, Int>()
        reportLists.forEach {
            reportCounts[it[1]] = reportCounts[it[1]]?.plus(1) ?: 1
        }
        println("!!! reportCounts : ${reportCounts.toString()} !!!")


        // 신고당한 횟수중에 k이상이여서 정지된 유저 리스트
        val suspensedUsers = reportCounts.filter { it.value >= 2 }.map { it.key }

        println("!!! suspensedUser : ${suspensedUsers.toString()} !!!")

        answer = id_list.map { id -> reportLists.filter { suspensedUsers.contains(it[1]) }.groupBy { it[0] }[id]?.size ?: 0 }.toIntArray()

        println("!!! answer : ${answer.asList()} !!!")

        return answer
    }


    private fun algorithm01_01(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        // report 2차 함수로으로 변환
        val reportLists = report.distinct().map { it.split(" ") }
        println("!!! reportLists : ${reportLists.toString()} !!!")

        report.toSet().groupBy { it.split(" ")[1] }

        // 정지 대상이 아닌 유저들
        val safeUsers = reportLists.groupBy { it[1] }.filter { it.value.size < k }.keys
        println("!!! safeUsers : $safeUsers !!!")

        val suspensedReportMap = reportLists.filter { !safeUsers.contains(it[1]) }
            .groupBy { it[0] }

        // 정지 대상 유저를 뺀 신고자의 신고 횟수
        answer = id_list.map { id ->
            suspensedReportMap[id]?.size ?: 0
        }.toIntArray()

        println("!!! answer : ${answer.asList()} !!!")

        return answer
    }


    companion object {
    }
}