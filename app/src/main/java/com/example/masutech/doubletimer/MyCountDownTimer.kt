package com.example.masutech.doubletimer

import android.os.CountDownTimer
import android.widget.TextView

class MyCountDownTimer(millsInFuture: Long): CountDownTimer(millsInFuture, 10) {

    private val tickListenerFuncList: ArrayList<(Long) -> Unit> = ArrayList()
    private val finishListenerFuncList: ArrayList<() -> Unit> = ArrayList()


    override fun onTick(millisUntilFinished: Long) = tickListenerFuncList.forEach { it(millisUntilFinished)}
    override fun onFinish() = finishListenerFuncList.forEach { it() }

    fun setOnTickListener(listener: (Long) -> Unit) = tickListenerFuncList.add(listener)
    fun setOnFinishListener(listener: () -> Unit) = finishListenerFuncList.add(listener)


}