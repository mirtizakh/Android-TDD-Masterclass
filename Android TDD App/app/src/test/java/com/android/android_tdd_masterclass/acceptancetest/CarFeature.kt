package com.android.android_tdd_masterclass.acceptancetest

import com.android.android_tdd_masterclass.Car
import junit.framework.Assert.assertEquals
import org.junit.Test

class CarFeature {

    val car = Car(6.0)
    @Test
    fun carIsLoosingFuelWhenItTurnOn(){
        car.turnOn()

      assertEquals(5.5,car.fuel)
    }
}