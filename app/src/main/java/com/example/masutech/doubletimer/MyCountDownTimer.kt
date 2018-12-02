package com.example.masutech.doubletimer

import android.os.CountDownTimer

class MyCountDownTimer(millsInFuture: Long): CountDownTimer(millsInFuture, 16) {

    var isRunning = false
        private set

    private val tickListenerFuncList: ArrayList<(Long) -> Unit> = ArrayList()
    private val finishListenerFuncList: ArrayList<() -> Unit> = ArrayList()

    init {
        setOnFinishListener { this.isRunning = false }
    }

    fun startTimer() {
        isRunning = true
        super.start()
    }

    fun stopTimer() {
        isRunning = false
        super.cancel()
    }


    override fun onTick(millisUntilFinished: Long) = tickListenerFuncList.forEach { it(millisUntilFinished)}
    override fun onFinish() = finishListenerFuncList.forEach { it() }

    fun setOnTickListener(listener: (Long) -> Unit) = tickListenerFuncList.add(listener)
    fun setOnFinishListener(listener: () -> Unit) = finishListenerFuncList.add(listener)


}