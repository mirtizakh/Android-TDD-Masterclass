package android.tddapp.groovy

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class PlaylistFeature {

    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @Rule get

    @Test
    fun displayScreenTitle() {
       assertDisplayed("Playlist")
    }
}