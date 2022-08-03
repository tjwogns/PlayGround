package com.example.playground.content.enum

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityEnumBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EnumActivity : BaseActivity<ActivityEnumBinding, EnumViewModel>(
    R.layout.activity_enum
) {

    override val viewModel: EnumViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()

    }


    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    private fun setListener() {
        /**
         * enum class의 values()로 객체를 찾을 때 새로운 객체르 만들어내는지 아니면 만들어진것의 주소만 복사되는지 확인.
         *
         * 결과는 이미 생성된 객체의 주소값을 복사.
         */
        binding.btnInput0.setOnClickListener {
            val a1 = Alphabet.getFromKey("A")
            val a2 = Alphabet.getFromKey("A")
            println("!!! a : ${a1 === a2}  !!!")
        }

        binding.btnInput1.setOnClickListener {
            val b = Alphabet.getFromKey("B").toString()
            println("!!! b : $b !!!")
        }

        binding.btnInput2.setOnClickListener {
            val c = Alphabet.getFromKey("C").toString()
            println("!!! c : $c !!!")
        }
    }


    /**
     * 구독
     */
    @SuppressLint("CheckResult")
    private fun subscribeObservable() {

    }

    companion object {
    }
}