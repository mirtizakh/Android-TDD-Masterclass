package com.example.outsideintddexample.acceptance

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class CarFeature {
    private val engine : Engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasingTheTemperature() = runBlocking {
        car.turnOn()

        assertTrue(car.engine.isTurnedOn)
        assertEquals(95, car.engine.temperature)
    }

}