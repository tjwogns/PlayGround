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