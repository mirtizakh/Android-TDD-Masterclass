package com.example.outsideintddexample

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine (
    var temperature: Int = 15,
    var isTurnedOn: Boolean =false
) {

    suspend fun turnOn() {
        delay(5000)
        temperature = 95
        isTurnedOn = true
    }

//    suspend fun turnOn() : Flow<Int> {
//        isTurnedOn = true
//        return flow{
//            delay(2000)
//            temperature = 25
//            emit(temperature)
//
//            delay(2000)
//            temperature = 50
//            emit(temperature)
//
//            delay(2000)
//            temperature = 95
//            emit(temperature)
//
//            Log.d("TDD","Engine is turned on ")
//        }
//    }
}