package com.example.playground.content.algorithm

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.N)
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

        binding.tvAlgorithm02.setOnClickListener {
            val lottos1 = intArrayOf(44, 1, 0, 0, 31, 25)
            val win_nums1 = intArrayOf(31, 10, 45, 1, 6, 19)

            val lotto2 = intArrayOf(0, 0, 0, 0, 0, 0)
            val win_nums2 = intArrayOf(38, 19, 20, 40, 15, 25)

            val lottos3 = intArrayOf(45, 4, 35, 20, 3, 9)
            val win_nums3 = intArrayOf(20, 9, 3, 45, 4, 35)

            algorithm02(lottos = lottos1, win_nums = win_nums1)

        }
    }


    // ============================================================================================

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

    @RequiresApi(Build.VERSION_CODES.N)
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
    // ============================================================================================

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/77484
     * 시작 시간 : 22.04.02 18:00
     * 소요 시간 : 1시간
     */
    private fun algorithm02(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        val matchedCount = win_nums.filter { lottos.contains(it) }.count()
        println("!!! matchedCount : $matchedCount !!!")

        val minRank = if  (7 - matchedCount >= 6) 6 else 7 - matchedCount
        println("!!! minRank : $minRank !!!")

        val unKnownNumberCount = lottos.count { it == 0 }
        println("!!! unKnownNumberCount : $unKnownNumberCount !!!")

        val maxRank = if (minRank - unKnownNumberCount <= 1) 1 else minRank - unKnownNumberCount
        println("!!! maxRank : $maxRank !!!")

        answer = intArrayOf(
            maxRank,
            minRank
        )

        println("!!! answer : ${answer.asList()} !!!")

        return answer
    }
    // ============================================================================================

    // ============================================================================================


    // ============================================================================================

    // ============================================================================================

    // ============================================================================================

    // ============================================================================================

    // ============================================================================================

    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================

}