package com.example.playground.content.print

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityPrintBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeoutException


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
            printTest01()
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

    companion object {
    }
}