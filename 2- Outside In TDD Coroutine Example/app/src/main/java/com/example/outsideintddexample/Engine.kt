package com.example.outsideintddexample

import kotlinx.coroutines.delay

class Engine (
    var temperature: Int = 15,
    var isTurnedOn: Boolean =false
) {

    // Let say our engine requiring a couple of seconds in order to start to turn on
    suspend fun turnOn() {
        delay(5000)
        temperature = 95
        isTurnedOn = true
    }
}