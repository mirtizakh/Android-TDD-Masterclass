package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import junit.framework.TestCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import petros.efthymiou.groovy.utils.getValueForTest


class PlaylistsDetailsViewModelShould : BaseUnitTest() {

    private val id: String = "1"
    lateinit var viewModel: PlaylistsDetailsViewModel
    private val mockService: PlaylistsDetailsService = spyk()
    private val mockPlaylistDetails: PlaylistsDetails = mockk()
    private val expected: Result<PlaylistsDetails> = Result.success(mockPlaylistDetails)

    @Test
    fun getPlaylistsDetailsFromService() {
        runBlocking {
            mockSuccessfulCase()
            coVerify(exactly = 1) { mockService.fetchPlaylistsDetails(id) }
        }
    }

    @Test
    fun emitPlaylistsDetailsFromService() {
        runBlocking {
            mockSuccessfulCase()
            TestCase.assertEquals(expected, viewModel.playlistsDetails.getValueForTest())
        }
    }

    private fun mockSuccessfulCase() {
        runBlocking {
            coEvery { mockService.fetchPlaylistsDetails(id) } returns flow {
                emit(expected)
            }
        }
        viewModel = PlaylistsDetailsViewModel(mockService)
        viewModel.getPlaylistsDetails(id)
    }
}