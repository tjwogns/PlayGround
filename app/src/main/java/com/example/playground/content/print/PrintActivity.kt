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


    companion object {
    }
}