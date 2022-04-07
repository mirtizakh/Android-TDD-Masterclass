package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.BaseUITest
import android.tddapp.groovy.R
import android.tddapp.groovy.playlists.idlingResource
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import org.hamcrest.Matchers
import org.junit.Test

class PlaylistsDetailsFeature : BaseUITest() {

    @Test
    fun displayPlaylistNameAndDetails() {
        navigateToPlaylistsDetailsScreen(0)

        assertDisplayed("Hard Rock Cafe")
        assertDisplayed("Rock your senses with this timeless signature vibe list. \n\n • Poison \n • You shook me all night \n • Zombie \n • Rock'n Me \n • Thunderstruck \n • I Hate Myself for Loving you \n • Crazy \n • Knockin' on Heavens Door")

    }


    @Test
    fun displayLoaderWhileFetchingThePlaylistsDetails() {
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
        Thread.sleep(2000)  // Just need to use in this case
        navigateToPlaylistsDetailsScreen(0)

        assertDisplayed(R.id.details_loader)
    }

    @Test
    fun displayErrorMessageWhenNetworkFails(){
        navigateToPlaylistsDetailsScreen(1)
        assertDisplayed(R.string.generic_error)
    }

    @Test
    fun hideErrorMessageAfterDisplay(){
        navigateToPlaylistsDetailsScreen(1)
        assertDisplayed(R.string.generic_error)
        Thread.sleep(4000)
        assertNotExist(R.string.generic_error)
    }

    @Test
    fun hideLoaderWhileFetchingThePlaylistsDetailsIsCompleted() {
        navigateToPlaylistsDetailsScreen(0)
        assertNotDisplayed(R.id.details_loader)
    }

    private fun navigateToPlaylistsDetailsScreen(item:Int) {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.playlists_image),
                ViewMatchers.isDescendantOfA(
                    nthChildOf(
                        ViewMatchers.withId(R.id.playlists_list),
                        item
                    )
                )
            )
        )
            .perform(ViewActions.click())
    }

}