package com.example.outsideintddexample.unittests

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

    private val car = Car(engine, 5.0)

    /* In order to test the coroutine We need to add a testing rule
       This rule is going to ensure that we are using the test dispatcher to run our coroutine and
       it is also going to clean up any coroutine that are left hanging after the execution of any test.
     */
    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runBlocking {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlocking {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }

}