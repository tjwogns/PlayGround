package com.example.playground.coordinatorLayout

import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

abstract class AppBarStateChangeListener: AppBarLayout.OnOffsetChangedListener {
    enum class State(val tag: Int) {
        EXPANDED(1),
        COLLAPSED(-1),
        IDLE(0)
    }


    private var currentState = State.IDLE

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (appBarLayout == null) return

        when {
            verticalOffset == 0 -> {
                if (currentState != State.EXPANDED) {
                    onStateChanged(appBarLayout, State.EXPANDED)
                    currentState = State.EXPANDED
                }
            }
            abs(verticalOffset) >= appBarLayout.totalScrollRange -> {
                if (currentState != State.COLLAPSED) {
                    onStateChanged(appBarLayout, State.COLLAPSED)
                    currentState = State.COLLAPSED
                }
            }
            else -> {
                if (currentState != State.IDLE) {
                    onStateChanged(appBarLayout, State.IDLE)
                    currentState = State.IDLE
                }
            }
        }

        if (appBarLayout.totalScrollRange != 0) {
            val percentage = verticalOffset.toFloat() / appBarLayout.totalScrollRange.toFloat() * 180
            onPercentageChanged(percentage)
        }
    }

    /**
     * Notifies on state change
     * @param appBarLayout Layout
     * @param state Collapse state
     */
    abstract fun onStateChanged(appBarLayout: AppBarLayout, state: State)

    /**
     * AppBarLayout 의 접힌 상태 (0 ~ 180)
     */
    abstract fun onPercentageChanged(percentage: Float)
}