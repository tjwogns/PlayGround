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

        binding.tvAlgorithm03.setOnClickListener {
            val numIdCase1 = "...!@BaT#*..y.abcdefghijklm"
            val numIdCase2 = "z-+.^."
            val numIdCase3 = "=.="
            val numIdCase4 = "123_.def"
            val numIdCase5 = "abcdefghijklmn.p"

            algorithm03(numIdCase1)
            algorithm03(numIdCase2)
            algorithm03(numIdCase3)
            algorithm03(numIdCase4)
            algorithm03(numIdCase5)

        }
    }


    // ============================================================================================

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/92334
     * ?????? ?????? : 22.03.27 15:20
     * ?????? ?????? : 2?????? ?????? ??????
     */
    private fun algorithm01_01(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        // report 2??? ??????????????? ??????
        val reportLists = report.distinct().map { it.split(" ") }
        println("!!! reportLists : ${reportLists.toString()} !!!")

        report.toSet().groupBy { it.split(" ")[1] }

        // ?????? ????????? ?????? ?????????
        val safeUsers = reportLists.groupBy { it[1] }.filter { it.value.size < k }.keys
        println("!!! safeUsers : $safeUsers !!!")

        val suspensedReportMap = reportLists.filter { !safeUsers.contains(it[1]) }
            .groupBy { it[0] }

        // ?????? ?????? ????????? ??? ???????????? ?????? ??????
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
     * ?????? ?????? : 22.04.02 18:00
     * ?????? ?????? : 1??????
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

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/72410
     * ?????? ?????? : 22.04.03 13:30
     * ?????? ?????? : 1?????? 30??? ??????
     */
    private fun algorithm03(new_id: String): String {
        val answer = new_id
            .lowercase() // 1?????? ???????????? ??????
            .replace(Regex("[~!@#\$%^&*()=+\\[{\\]}:?,<>/]"),"") // 2??????  ????????? ?????????, ??????, ??????(-), ??????(_), ?????????(.)??? ????????? ?????? ????????? ???????????????.
            .replace(Regex("\\.{2,}"), ".") // 3?????? ?????????(.)??? 2??? ?????? ????????? ????????? ????????? ?????????(.)??? ???????????????.
            .run {
                var id = this
                if (id.isNotEmpty() && id.first().toString() == (".")) id = id.substring(1)
                if (id.isNotEmpty() && id.last().toString() == (".")) id = id.substring(0, this.lastIndex)
                // 4?????? ?????????(.)??? ???????????? ?????? ??????????????? ???????????????.
                if (id.isEmpty()) id = "a" // 5 ?????? ??? ??????????????????, new_id??? "a"??? ???????????????.
                if (id.length > 15) id = id.substring(0, 15)
                if (id.last().toString() == (".")) id = id.substring(0, id.lastIndex)
                // 6?????? ????????? 16??? ????????????, new_id??? ??? 15?????? ????????? ????????? ????????? ???????????? ?????? ???????????????. + ????????? (.) ??????
                while (id.length < 3) id = id.plus(id.last())
                return@run id
            }

        println("!!! anwser : $answer !!!")
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

}