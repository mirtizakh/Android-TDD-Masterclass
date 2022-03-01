package com.example.outsideintddexample

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class Engine (
    var temperature: Int = 15,
    var isTurnedOn: Boolean =false
) {

    suspend fun turnOn() : Flow<Int>{
        isTurnedOn = true

        Log.d("COURSE", "Engine has turned on")

        return flow {
            delay(1000)
            temperature = 25
            emit(temperature)
            delay(1000)
            temperature = 50
            emit(temperature)
            delay(1000)
            temperature = 95
            emit(temperature)
        }
    }
}