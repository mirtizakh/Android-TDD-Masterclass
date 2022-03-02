package com.android.android_tdd_masterclass.unittest

import com.android.android_tdd_masterclass.Car
import junit.framework.Assert.assertEquals
import org.junit.Test

class CarShould {

    val car = Car(5.0)

    @Test
    fun looseFuelWhenItTurnsOn(){
       car.turnOn()

       assertEquals(4.5,car.fuel)
    }
}