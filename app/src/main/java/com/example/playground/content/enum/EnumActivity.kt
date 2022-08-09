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
         * return ture
         * 결과는 이미 생성된 객체의 주소값을 복사.
         */
        binding.btnInput0.setOnClickListener {
            val a1 = Alphabet.getFromKey("A")
            val a2 = Alphabet.getFromKey("A")
            println("!!! a : ${a1 === a2}  !!!")
        }

        /**
         * return false
         * 위의 실험과 차이가 있으므로 확인할수 있는 사실.
         * value()객체로 만들어지는 것 안에 값들은 이미 만들어진 객체값들의 주소를 담아서 test1에서처럼 같다고 나오지만
         * value()로 만들어 지는 array 객체 자체는 다른 것으로 만들어져 이미 가지고있는 객체의 값으로 안이 채워진다는것을 확인할 수 있다.
         */
        binding.btnInput1.setOnClickListener {
            val b1 = Alphabet.gets()
            val b2 = Alphabet.gets()

            println("!!! b : ${b1 === b2}  !!!")
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