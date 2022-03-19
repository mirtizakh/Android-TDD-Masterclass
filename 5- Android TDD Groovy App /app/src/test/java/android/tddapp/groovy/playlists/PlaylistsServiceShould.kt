package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistsServiceShould : BaseUnitTest() {

    private val mockPlaylistsAPI = spyk<PlaylistsAPI>()

    @Test
    fun fetchPlaylistsFromAPI() {
        runBlocking {
            val service = PlaylistsService(mockPlaylistsAPI)
            service.fetchPlaylists()
            coVerify(exactly = 1) { mockPlaylistsAPI.fetchAllPlaylists() }
        }
    }

}