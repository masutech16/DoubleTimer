package com.example.masutech.doubletimer

fun formatTime(num: Long): String {
    val minute = num / (1000 * 60)
    val minuteStr = formatNumber(minute)

    val second = (num / 1000) % 60
    val secondStr = formatNumber(second)

    val mill = (num / 10) % 100
    val millStr = formatNumber(mill)

    return minuteStr.plus(":").plus(secondStr).plus(":").plus(millStr)
}

private fun formatNumber(num: Long) : String = if (num < 10) "0$num" else "$num"