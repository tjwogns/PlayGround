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
            printTest11()
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

    private fun printTest06() {
        val a = getString(R.string.test_argument)
        val b = getString(R.string.test_argument2)

        val aResult = String.format(a, "가", "나")
        val bResult = String.format(b, "다")

        println("!!! DEBUG !!! aResult [$aResult]")
        println("!!! DEBUG !!! bResult [$bResult]")
    }


    private fun printTest07() {
        val test = "https://www.jerry.com"
        val test2 = "https://www.jerry.com?iframe=Y"
        val uri1 = Uri.parse(test)
        val uri2 = Uri.parse(test2)

        val result = uri1.getQueryParameter("iframe")
        val result2 = uri2.getQueryParameter("iframe")

        println("!!! DEBUG !!! result[$result]")
        println("!!! DEBUG !!! result2[$result2]")

        val result3 = Uri.parse(test)
            .buildUpon()
            .apply {
                if (this.build().getQueryParameter("iframe") == null) this.appendQueryParameter("iframe", "Y")
            }.build()

        println("!!! DEBUG !!! result3[$result3]")

    }


    enum class State(val tag: Int) {
        EXPANDED(1),
        COLLAPSED(-1),
        IDLE(0)
    }

    private fun printTest08() {
        val test1 = State.EXPANDED.name
        val test2 = State.COLLAPSED.name
        val test3 = State.IDLE.name

        println("!!! DEBUG !!! test1 [$test1]")
        println("!!! DEBUG !!! test2 [$test2]")
        println("!!! DEBUG !!! test3 [$test3]")

        val result = State.valueOf("EXPANDED")

        println("!!! DEBUG !!! result [$result]")
    }

    private fun printTest09() {
        val test1 = "abcdefg"
        val test2 = "안녕하세요."
        val test3 = "123456하이Hi!@#"

        test1.toStringList().forEach {
            println("!!! DEBUG !!! [$it]")
        }
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

        test2.toStringList().forEach {
            println("!!! DEBUG !!! [$it]")
        }
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        test3.toStringList().forEach {
            println("!!! DEBUG !!! [$it]")
        }
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")


    }

    private fun printTest10() {
        val test1 = TestType.SON

        println("!!! DEBUG !!! [${test1 == null}]")
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }

    private fun printTest11() {
        val cacheDir = applicationContext.cacheDir

        println("!!! DEBUG !!! cacheDir [${cacheDir}]")
    }

    private fun String.toStringList(): List<String> {
        return this.map {
            String(CharArray(1) { _ -> it })
        }
    }

    companion object {
    }
}


data class TestType(
    val name: String,
    val subName: String
) {

    companion object {
        val SON = TestObject.SON
        val SON2 = TestObject.SON2()
    }

}

object TestObject {
    val SON = TestType(
        "son",
        "min"
    )

    fun SON2() = TestType(
        "son",
        "min"
    )
}