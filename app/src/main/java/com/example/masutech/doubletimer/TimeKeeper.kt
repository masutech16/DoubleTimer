package com.example.masutech.doubletimer

import android.widget.TextView


class TimeKeeper() {
    var countTime = 0L
        private set

    fun resetTime() {
        countTime = 0
    }

    fun addTimeBySeconds(addingSeconds : Int) {
        val addingMillSeconds = addingSeconds * 1000
        countTime = if (addingMillSeconds + countTime < 0) 0 else countTime + addingMillSeconds
    }
}