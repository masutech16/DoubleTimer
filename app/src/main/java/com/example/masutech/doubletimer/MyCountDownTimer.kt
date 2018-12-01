package com.example.masutech.doubletimer

import android.os.CountDownTimer
import android.widget.TextView

class MyCountDownTimer(millsInFuture: Long, private val timerText: TextView): CountDownTimer(millsInFuture, 10) {

    override fun onTick(millisUntilFinished: Long) {
        timerText.text = formatTime(millisUntilFinished)
    }

    override fun onFinish() {
        timerText.text = "Time up!"
    }


}