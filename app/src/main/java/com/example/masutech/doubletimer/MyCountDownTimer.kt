package com.example.masutech.doubletimer

import android.os.CountDownTimer

class MyCountDownTimer() {

    inner class MyTimer(millsInFuture: Long): CountDownTimer(millsInFuture, 16) {
        override fun onFinish() = finishListenerFuncList.forEach {it()}
        override fun onTick(millisUntilFinished: Long) = tickListenerFuncList.forEach {it(millisUntilFinished)}
    }

    private var timer:MyTimer? = null


    var isRunning = false
        private set

    private val tickListenerFuncList: ArrayList<(Long) -> Unit> = ArrayList()
    private val finishListenerFuncList: ArrayList<() -> Unit> = ArrayList()


    init {
        setOnFinishListener { this.isRunning = false }
    }

    fun startTimer(millsInFuture: Long) {
        timer = MyTimer(millsInFuture)
        timer?.start()
        isRunning = true

    }

    fun stopTimer() {
        if (timer == null) return
        timer?.cancel()
        isRunning = false
    }

    fun setOnTickListener(listener: (Long) -> Unit) = tickListenerFuncList.add(listener)
    fun setOnFinishListener(listener: () -> Unit) = finishListenerFuncList.add(listener)


}