package com.example.outsideintddexample.acceptancetests

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()

    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runBlocking {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runBlocking {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(5001)
        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }

}