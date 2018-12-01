package com.example.masutech.doubletimer

class Timer {
    private var countTime = 0L

    public fun AddTimeBySeconds(addingSeconds : Int) {
        countTime += addingSeconds * 1000
    }

    public fun AddTimeByMinutes(addingMinutes : Int) {
        countTime += addingMinutes * 60 * 1000
    }


}