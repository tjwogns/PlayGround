package com.example.playground.content.algorithm

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityAlgorithmBinding
import kotlinx.coroutines.selects.select
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.math.min

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

//            algorithm01_02(idList, report, k)
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

        binding.tvAlgorithm04.setOnClickListener {
            val case1 = "aabbaccc"
            val case2 = "ababcdcdababcdcd"
            val case3 = "abcabcdede"
            val case4 = "abcabcabcabcdededededede"
            val case5 = "xababcdcdababcdcd"
            val case6 = "a"

            algorithm04(case6)
        }

        binding.tvAlgorithm05.setOnClickListener {
            val case1 = arrayOf<String>("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
            val case2 = arrayOf<String>()
            val case3 = arrayOf<String>()
            val case4 = arrayOf<String>()
            val case5 = arrayOf<String>()
            val case6 = arrayOf<String>()

            algorithm05(case1)
        }

        binding.tvAlgorithm06.setOnClickListener {
            val case1 = intArrayOf(3,2,7,2) to intArrayOf(4,6,5,1)
            val case2 = intArrayOf(1,2,1,2) to intArrayOf(1,10,1,2)
            val case3 = intArrayOf(1,1) to intArrayOf(1,5)

//            algorithm06()

            algorithm06(case2.first, case2.second)
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

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/72410
     * 시작 시간 : 22.04.03 13:30
     * 소요 시간 : 1시간 30분 소요
     */
    private fun algorithm03(new_id: String): String {
        val answer = new_id
            .lowercase() // 1단계 소문자로 치환
            .replace(Regex("[~!@#\$%^&*()=+\\[{\\]}:?,<>/]"),"") // 2단계  알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            .replace(Regex("\\.{2,}"), ".") // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            .run {
                var id = this
                if (id.isNotEmpty() && id.first().toString() == (".")) id = id.substring(1)
                if (id.isNotEmpty() && id.last().toString() == (".")) id = id.substring(0, this.lastIndex)
                // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
                if (id.isEmpty()) id = "a" // 5 단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
                if (id.length > 15) id = id.substring(0, 15)
                if (id.last().toString() == (".")) id = id.substring(0, id.lastIndex)
                // 6단계 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. + 마지막 (.) 제거
                while (id.length < 3) id = id.plus(id.last())
                return@run id
            }

        println("!!! anwser : $answer !!!")
        return answer
    }

    // ============================================================================================
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/72410
     * 시작 시간 :
     * 소요 시간 : 1시간 40분
     */
    private fun algorithm04(s: String): Int {

        // 크기가 1이면 반복문 조차 돌지 않아서 예외처리
        if (s.length == 1) return 1

        val repeatCount = s.length / 2

        var shortString = ""

        // 반복문 처리의 시작
        mainLoop@ for (i in 1 until repeatCount + 1) {
            val buffer = StringBuffer()

            var startIndex = 0
            var endIndex = i

            // 자른 단어 같은게있는지 루프
            loop@ while (endIndex <= s.length) {
                val target = s.substring(startIndex, endIndex)

                var count = 0

                while (target == s.substring(startIndex, endIndex)) {
                    count ++
                    startIndex = endIndex
                    endIndex = startIndex + i
                    if (endIndex > s.length) {
                        break
                    }
                }

                buffer.apply {
                    if (count > 1) append(count)
                    append(target)
                }

                if (shortString.isNotEmpty() && shortString.length < buffer.toString().length) continue@mainLoop
            }

            if (startIndex < s.length) buffer.append(s.substring(startIndex, s.lastIndex + 1))

            if (shortString.isEmpty() || buffer.toString().length < shortString.length) shortString = buffer.toString()
        }

        return shortString.length
    }

    // ============================================================================================
    /*
     * https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=kotlin
     * 시작 시간 :
     * 소요 시간 :
     */
    private fun algorithm05(record: Array<String>): Array<String> {
        val answer = mutableListOf<String>()

        record
            .map { it.split(" ") }
            .run {

                val userData = mutableMapOf<String, String>()
                this.filter { it[0] == "Enter" || it[0] == "Change" }.asSequence().forEach {
                    userData[it[1]] = it[2]
                }

                this.filter { it[0] == "Enter" || it[0] == "Leave" }.asSequence().forEach {
                    answer.add(
                        buildResultString(
                            keyword = it[0],
                            nickName = userData[it[1]]!!
                        )
                    )
                }
            }


        return answer.toTypedArray()
    }

    private fun buildResultString(keyword: String, nickName: String): String {
        return when (keyword) {
            "Enter" -> "${nickName}님이 들어왔습니다."
            "Leave" -> "${nickName}님이 나갔습니다."
            else -> ""

        }
    }
    // ============================================================================================
// ============================================================================================
    /*
     * https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=kotlin
     * 시작 시간 :
     * 소요 시간 :
     */
    private fun algorithm06(queue1: IntArray, queue2: IntArray): Int {

        // 합이 홀수면 -1 리턴
        if ((queue1.sum() + queue2.sum()) % 2 != 0) return -1

        val target = (queue1.sum().toLong() + queue2.sum().toLong()) / 2
        val maxCount = queue1.size * 3


        val queue1ToArray = LinkedList(queue1.toMutableList())
        val queue2ToArray = LinkedList(queue2.toMutableList())

        var sum1 = queue1ToArray.sum().toLong()
        var sum2 = queue2ToArray.sum().toLong()

        var answer = 0

        for (t in 0 .. maxCount) {
            if (sum1 == target) {
                break
            } else if (sum1 > target) {
                val popValue = queue1ToArray.remove()
                queue2ToArray.add(popValue)
                sum1 -= popValue
                sum2 += popValue

                answer += 1
            } else {
                val popValue = queue2ToArray.remove()
                queue1ToArray.add(popValue)

                sum1 += popValue
                sum2 -= popValue

                answer += 1
            }

        }

        if (queue1ToArray.sum() != queue2ToArray.sum()) return -1
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

}