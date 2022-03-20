package android.tddapp.groovy

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.internal.matcher.DrawableMatcher.Companion.withDrawable
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PlaylistsFeature {

    val activityRule = ActivityScenarioRule(MainActivity::class.java)
        @Rule get

    // Check the title of MainActivity
    @Test
    fun displayScreenTitle() {
        assertDisplayed("Playlists")
    }

    // Check the items in recyclerview
    @Test
    fun displaysListOfPlaylists() {
        Thread.sleep(4000)

        assertRecyclerViewItemCount(R.id.playlists_list, 10)

        onView(
            allOf(
                withId(R.id.playlists_name),
                isDescendantOfA(nthChildOf(withId(R.id.playlists_list), 0))
            )
        )
            .check(matches(withText("Hard Rock Cafe")))
            .check(matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.playlists_category),
                isDescendantOfA(nthChildOf(withId(R.id.playlists_list), 1))
            )
        )
            .check(matches(withText("rock")))
            .check(matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.playlists_image),
                isDescendantOfA(nthChildOf(withId(R.id.playlists_list), 0))
            )
        )
            .check(matches(withDrawable(R.mipmap.playlist)))
            .check(matches(isDisplayed()))
    }

    @Test
    fun displayLoaderWhileFetchingThePlaylists() {
        assertDisplayed(R.id.loader)
    }

    @Test
    fun hideLoaderWhileFetchingThePlaylistsIsCompleted() {
        Thread.sleep(5000)
        assertNotDisplayed(R.id.loader)
    }

    @Test
    fun displayRockImageForRockListsItems() {
        Thread.sleep(4000)

        onView(
            allOf(
                withId(R.id.playlists_image),
                isDescendantOfA(nthChildOf(withId(R.id.playlists_list), 0))
            )
        )
            .check(matches(withDrawable(R.drawable.rock)))
            .check(matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.playlists_image),
                isDescendantOfA(nthChildOf(withId(R.id.playlists_list), 3))
            )
        )
            .check(matches(withDrawable(R.drawable.rock)))
            .check(matches(isDisplayed()))
    }

    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("position $childPosition of parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                if (view.parent !is ViewGroup) return false
                val parent = view.parent as ViewGroup

                return (parentMatcher.matches(parent)
                        && parent.childCount > childPosition
                        && parent.getChildAt(childPosition) == view)
            }
        }
    }

}