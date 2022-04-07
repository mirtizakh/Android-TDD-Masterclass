package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.playlists.PlaylistsAPI
import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistsDetailsServiceShould : BaseUnitTest() {
    private val mockPlaylistsAPI = mockk<PlaylistsAPI>()
    private val mockPlaylistDetails: PlaylistsDetails = mockk()
    private val id: String = "1"

    @Test
    fun getPlayListsDetailsFromService() {
        runBlocking {
            val playlistsService = PlaylistsDetailsService(mockPlaylistsAPI)
            playlistsService.fetchPlaylistsDetails(id).single()
            coVerify(exactly = 1) { mockPlaylistsAPI.fetchPlaylistsDetails() }
        }
    }

    @Test
    fun convertValuesToFlowResultAndEmitThem() {
        runBlocking {
            coEvery { mockPlaylistsAPI.fetchPlaylistsDetails() } returns mockPlaylistDetails
            val playlistsService = PlaylistsDetailsService(mockPlaylistsAPI)
            TestCase.assertEquals(
                Result.success(mockPlaylistDetails),
                playlistsService.fetchPlaylistsDetails(id).single()
            )
        }
    }

    @Test
    fun emitErrorResultWhenNetworkFails() {
        runBlocking {
            coEvery { mockPlaylistsAPI.fetchPlaylistsDetails() } throws RuntimeException("Network exception")
            val playlistsService = PlaylistsDetailsService(mockPlaylistsAPI)
            TestCase.assertEquals(
                RuntimeException("Network exception"),
                playlistsService.fetchPlaylistsDetails(id).first().exceptionOrNull()!!
            )
            TestCase.assertEquals(
                "Network exception",
                playlistsService.fetchPlaylistsDetails(id).first().exceptionOrNull()!!.message
            )
        }
    }
}