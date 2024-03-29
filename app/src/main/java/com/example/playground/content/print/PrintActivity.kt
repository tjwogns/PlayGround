package com.example.playground.content.print

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityPrintBinding
import org.joda.time.DateTime
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.HashMap


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
            printTest04()
        }

        binding.tvPrint3.setOnClickListener {
            val url1 = "https://github.com/tjwogns?a=1&b=2&c=3"
            val url2 = "https://github.com/tjwogns"
            val url3 = "https://github.com/tjwogns?iframe=Y&a=1&b=2&c=3"

            printTest05(url1)
            printTest05(url2)
            printTest05(url3)
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

    private fun printTest04() {
        println("!!! DEBUG DateTime.now().millis : ${DateTime.now().millis} !!!")
        println("!!! DEBUG DateTime.now().millisOfDay().dateTime.millis : ${DateTime.now().millisOfDay().dateTime.millis} !!!")
        println("!!! DEBUG DateTime.now().millisOfDay().withMillisOfDay(0).millis : ${DateTime.now().withMillisOfDay(0).millis} !!!")
        println("!!! DEBUG DateTime.now().dayOfWeek().get() : ${DateTime.now().dayOfWeek().get()} !!!")
        println("!!! DEBUG DateTime.now().year : ${DateTime.now().year} !!!")
    }

    /**
     * Uri Param Test
     */
    private fun printTest05(url: String) {
        println("!!!!!!!!!!!!!!!!!! DEBUG !!! target url [$url] !!!!!!!!!!!!!!!!!!")

        val uri = Uri.parse(url)
        val paramKey = uri.queryParameterNames

        paramKey.forEachIndexed { index, s ->
            println("!!! DEBUG !!! param[$index] : $s")
        }

        paramKey.forEachIndexed { index, s ->
            println("!!! DEBUG !!! param[$s].value : ${uri.getQueryParameter(s)}")
        }


        val urlStringBuilder = StringBuilder(url).apply {
            if (paramKey.isEmpty()) {
                println("!!! DEBUG !!! printTest05 url param empty, add '?'")
                this.append('?')
            } else {
                this.append("&")
            }
            if (true) {
                this.append("id=${"paramA"}")
                this.append("&home_id=${"paramB"}")
            }
            this.append("&source_country=${"paramC"}")
            this.append("&destination_country=${"paramD"}")
            if (!paramKey.contains("iframe")) {
                println("!!! DEBUG !!! printTest05 not exist 'iframe', add 'iframe'")
                this.append("&iframe=Y")
            }
        }

        println("!!! DEBUG !!! Output String [$urlStringBuilder]")
    }


    companion object {
    }
}