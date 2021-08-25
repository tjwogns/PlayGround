package com.example.playground.content.flow

import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import androidx.core.os.ConfigurationCompat
import androidx.lifecycle.asLiveData
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class FlowViewModel: BaseViewModel() {

    var baseData = getBaseFlow().asLiveData()
    ///////////////////////////////////////////////
    // <createByBuilder Result>
    ///////////////////////////////////////////////
    fun getBaseFlow(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i)
            println("println : $i")
        }

    }

}