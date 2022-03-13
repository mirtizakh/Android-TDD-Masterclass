package com.example.outsideintddexample.unit_test

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import org.junit.Test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking


class CarShould {
    private val engine : Engine = mock()
    private val car = Car(engine,4.0)

    @Test
    fun looseFuelWhenItTurnOn() {
        car.turnOn()

        assertEquals(3.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlocking {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}