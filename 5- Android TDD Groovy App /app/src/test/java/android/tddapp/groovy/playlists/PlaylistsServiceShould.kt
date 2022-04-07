package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistsServiceShould : BaseUnitTest() {

    private val mockPlaylists: List<PlaylistsRaw> = mockk()
    private val mockPlaylistsAPI = mockk<PlaylistsAPI>()

    @Test
    fun fetchPlaylistsFromAPI() {
        runBlocking {
            val service = PlaylistsService(mockPlaylistsAPI)
            service.fetchPlaylists().first()
            coVerify(exactly = 1) { mockPlaylistsAPI.fetchAllPlaylists() }
        }
    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem() {
        runBlocking {
            coEvery { mockPlaylistsAPI.fetchAllPlaylists() } returns mockPlaylists
            val service = PlaylistsService(mockPlaylistsAPI)
            assertEquals(Result.success(mockPlaylists), service.fetchPlaylists().first())
        }
    }

    @Test
    fun emitsErrorResultsWhenNetworkFails() {
        runBlocking {
            coEvery { mockPlaylistsAPI.fetchAllPlaylists() } throws RuntimeException("Something went wrong")
            val service = PlaylistsService(mockPlaylistsAPI)
            assertEquals(
                "Something went wrong",
                service.fetchPlaylists().first().exceptionOrNull()!!.message
            )
        }
    }

}