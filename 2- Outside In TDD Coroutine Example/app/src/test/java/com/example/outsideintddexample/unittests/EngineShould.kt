package com.example.outsideintddexample.unittests

import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlocking {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureWhenItTurnsOn() = runBlocking {
        engine.turnOn()

        assertEquals(95, engine.temperature)

    }
}