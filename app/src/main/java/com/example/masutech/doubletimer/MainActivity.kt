package com.example.masutech.doubletimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerView1 = findViewById<TextView>(R.id.TimerView1)
        val timerView2 = findViewById<TextView>(R.id.TimerView2)

        // timekeeper, timerを初期化
        val timeKeeper1 = TimeKeeper()
        val timeKeeper2 = TimeKeeper()

        var timer1:MyCountDownTimer? = null
        var timer2:MyCountDownTimer? = null

        // buttonにイベントを追加
        findViewById<Button>(R.id.One_min1).setOnClickListener(onClickTimeButtonEvent(timeKeeper1, timerView1, 60))
        findViewById<Button>(R.id.Thirty_sec1).setOnClickListener(onClickTimeButtonEvent(timeKeeper1, timerView1, 30))

        findViewById<Button>(R.id.Start1).setOnClickListener {
            if (timer1?.isRunning == true) return@setOnClickListener
            timer1 = MyCountDownTimer(timeKeeper1.countTime)
            timer1?.startTimer()
            startTimer(timer1!!, timerView1)

        }

        findViewById<Button>(R.id.Stop1).setOnClickListener {
            timer1?.stopTimer()
            timeKeeper1.resetTime()
            timerView1.text = formatTime(0)
        }


        findViewById<Button>(R.id.One_min2).setOnClickListener(onClickTimeButtonEvent(timeKeeper2, timerView2, 60))
        findViewById<Button>(R.id.Thirty_min2).setOnClickListener(onClickTimeButtonEvent(timeKeeper2, timerView2, 30))

        findViewById<Button>(R.id.Start2).setOnClickListener {
            if (timer2?.isRunning == true) return@setOnClickListener
            timer2 = MyCountDownTimer(timeKeeper2.countTime)
            timer2?.start()
            startTimer(timer2!!, timerView2)
        }

        findViewById<Button>(R.id.Stop2).setOnClickListener {
            timer2?.stopTimer()
            timeKeeper2.resetTime()
            timerView2.text = formatTime(0)
        }
    }

    private fun onClickTimeButtonEvent(timeKeeper: TimeKeeper, timerView: TextView, addSecondTime: Int): View.OnClickListener {
        return View.OnClickListener {
            timeKeeper.addTimeBySeconds(addSecondTime)
            timerView.text = formatTime(timeKeeper.countTime)
        }
    }

    private fun startTimer(timer: MyCountDownTimer,  timerView: TextView) {
        timer.setOnTickListener {millsUntilFinished -> timerView.text = formatTime(millsUntilFinished) }
        timer.setOnFinishListener { timerView.text = "Time up!" }
    }
}
