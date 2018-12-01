package com.example.masutech.doubletimer

import org.junit.Test

import org.junit.Assert.*

class TimeKeeperTest {

    @Test
    fun test_ResetTime() {
        val timer = TimeKeeper()

        // 初期値は0
        assertEquals(0L, timer.countTime)

        // 何かを加えると0ではなくなる
        timer.addTimeBySeconds(300)
        assertNotEquals(0L, timer.countTime)

        timer.resetTime()
        assertEquals(0L, timer.countTime)

    }

    @Test
    fun test_AddTimeBySeconds() {
        val timer = TimeKeeper()

        // 正の数を加えたらその数だけ増える
        timer.addTimeBySeconds(30)
        assertEquals(30 * 1000, timer.countTime)

        // 0じゃない状態に加算したらそのまま増える
        timer.addTimeBySeconds(40)
        assertEquals(70 * 1000, timer.countTime)

        timer.resetTime()

        // 負の数を加えた場合は0を下回らないようにする
        timer.addTimeBySeconds(-20)
        assertEquals(0, timer.countTime)

        timer.resetTime()

        timer.addTimeBySeconds(30)
        timer.addTimeBySeconds(-20)
        assertEquals(10 * 1000, timer.countTime)

    }
}