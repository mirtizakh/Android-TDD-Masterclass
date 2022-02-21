package com.example.outsideintddexample

class Engine (
    var temperature: Int = 15,
    var isTurnedOn: Boolean =false
) {

    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }
}