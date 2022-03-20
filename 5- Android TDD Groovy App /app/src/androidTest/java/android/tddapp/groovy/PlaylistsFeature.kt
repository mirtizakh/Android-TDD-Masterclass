package android.tddapp.groovy

import android.tddapp.groovy.playlists.idlingResource
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.internal.matcher.DrawableMatcher.Companion.withDrawable
import org.hamcrest.Matchers.allOf
import org.junit.Test

class PlaylistsFeature : BaseUITest() {

    // Check the title of MainActivity
    @Test
    fun displayScreenTitle() {
        assertDisplayed("Playlists")
    }

    // Check the items in recyclerview
    @Test
    fun displaysListOfPlaylists() {
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
        /*
         This test is failing because we expect to display the loader while fetching the playlists.
         This is actually happening because our idling resource is causing the thread to sleep until we get
         the result of the playlists from the API while the thread is sleeping .
         While the thread is sleeping we cannot perform the assertions .
         So in this case we don't want to block the execution of our test while we are fetching
         the playlists from the API.
         So we need to add   IdlingRegistry.getInstance().unregister(idlingResource)
         */
        IdlingRegistry.getInstance().unregister(idlingResource)
        assertDisplayed(R.id.loader)
    }

    @Test
    fun hideLoaderWhileFetchingThePlaylistsIsCompleted() {
        assertNotDisplayed(R.id.loader)
    }

    @Test
    fun displayRockImageForRockListsItems() {
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

    @Test
    fun navigateToDetailScreen() {
        onView(
            allOf(
                withId(R.id.playlists_image),
                isDescendantOfA(nthChildOf(withId(R.id.playlists_list), 0))
            )
        )
            .perform(click())

        assertDisplayed(R.id.fragment_playlists_details_root)
    }
}