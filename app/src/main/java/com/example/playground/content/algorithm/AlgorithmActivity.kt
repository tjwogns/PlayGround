package com.example.playground.content.algorithm

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityAlgorithmBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlgorithmActivity: BaseActivity<ActivityAlgorithmBinding, AlgorithmViewModel>(
    R.layout.activity_algorithm
) {

    override val viewModel: AlgorithmViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    private fun setListener() {
        binding.tvAlgorithm01.setOnClickListener {
            val idList = arrayOf("muzi", "frodo", "apeach", "neo")
            val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
            val k = 2

//            val idList = arrayOf("con", "ryan")
//            val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
//            val k = 3

            algorithm01_02(idList, report, k)
        }
    }



    /**
     * https://programmers.co.kr/learn/courses/30/lessons/92334
     * 시작 시간 : 22.03.27 15:20
     * 소요 시간 : 2시간 정도 소요
     */
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

    private fun algorithm01_02(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        return report.map { it.split(" ") }
            .groupBy { it[1] }
            .asSequence()
            .map { it.value.distinct() }
            .filter { it.size >= k }
            .flatten()
            .map { it[0] }
            .groupingBy { it }
            .eachCount()
            .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
    }
}