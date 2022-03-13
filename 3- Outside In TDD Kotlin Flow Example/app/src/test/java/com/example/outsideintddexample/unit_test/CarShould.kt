package com.example.outsideintddexample.unit_test

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test


class CarShould {
    private val engine: Engine = mock()
    private val car = Car(engine, 4.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnOn() = runBlocking {
        car.turnOn()

        assertEquals(3.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        runBlocking {
            car.turnOn()

            verify(engine, times(1)).turnOn()
        }
    }
}