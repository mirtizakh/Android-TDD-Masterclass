package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import petros.efthymiou.groovy.utils.captureValues
import petros.efthymiou.groovy.utils.getValueForTest


class PlaylistsDetailsViewModelShould : BaseUnitTest() {

    private val id: String = "1"
    lateinit var viewModel: PlaylistsDetailsViewModel
    private val mockService: PlaylistsDetailsService = mockk()
    private val mockPlaylistDetails: PlaylistsDetails = mockk()
    private val expected: Result<PlaylistsDetails> = Result.success(mockPlaylistDetails)
    private val exception = RuntimeException("Something went wrong")
    private val error = Result.failure<PlaylistsDetails>(exception)

    @Test
    fun getPlaylistsDetailsFromService() {
        runBlocking {
            mockSuccessfulCase()
            viewModel.getPlaylistsDetails(id)
            coVerify(exactly = 1) { mockService.fetchPlaylistsDetails(id) }
        }
    }

    @Test
    fun emitErrorWhenServiceFails() {
        runBlocking {
            mockErrorCase()
            TestCase.assertEquals(error, viewModel.playlistsDetails.getValueForTest())
        }
    }

    @Test
    fun emitPlaylistsDetailsFromService() {
        runBlocking {
            mockSuccessfulCase()
            viewModel.getPlaylistsDetails(id)
            TestCase.assertEquals(expected, viewModel.playlistsDetails.getValueForTest())
        }
    }

    @Test
    fun showProgressBarWhileLoading() {
        runBlocking {
            mockSuccessfulCase()
            viewModel.loader.captureValues {
                viewModel.getPlaylistsDetails(id)
                // Below line is extra code we can remove it
                viewModel.playlistsDetails.getValueForTest()
                TestCase.assertEquals(true, values[0])
            }
        }
    }

    @Test
    fun hideProgressBarAfterPlaylistsDetailsFetchIsCompleted() {
        runBlocking {
            mockSuccessfulCase()
            viewModel.getPlaylistsDetails(id)
            viewModel.loader.captureValues {
                TestCase.assertEquals(false, values.last())
            }
        }
    }

    private fun mockSuccessfulCase() {
        runBlocking {
            coEvery { mockService.fetchPlaylistsDetails(id) } returns flow {
                emit(expected)
            }
        }
        viewModel = PlaylistsDetailsViewModel(mockService)
    }

    private fun mockErrorCase() {
        runBlocking {
            coEvery { mockService.fetchPlaylistsDetails(id) } returns flow {
                emit(error)
            }
        }
        viewModel = PlaylistsDetailsViewModel(mockService)
        viewModel.getPlaylistsDetails(id)
    }
}