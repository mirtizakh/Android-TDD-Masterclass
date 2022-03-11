package com.example.outsideintddexample

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class Car(
    val engine: Engine,
    var fuel: Double
) {

    fun turnOn() {
        fuel -= 0.5

        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collect {
                Log.d("COURSE", "the temperature of the engine is $it")
            }
        }
    }
}