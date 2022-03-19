package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistsServiceShould : BaseUnitTest() {

    private val mockPlaylists: List<Playlists> = mockk()
    private val mockPlaylistsAPI = spyk<PlaylistsAPI>()

    @Test
    fun fetchPlaylistsFromAPI() {
        runBlocking {
            val service = PlaylistsService(mockPlaylistsAPI)
            service.fetchPlaylists()
            coVerify(exactly = 1) { mockPlaylistsAPI.fetchAllPlaylists() }
        }
    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem(){
        runBlocking {
            coEvery { mockPlaylistsAPI.fetchAllPlaylists() } returns mockPlaylists
            val service = PlaylistsService(mockPlaylistsAPI)
            assertEquals(Result.success(mockPlaylists),service.fetchPlaylists().first())
        }
    }

}