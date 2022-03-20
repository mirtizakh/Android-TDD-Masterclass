package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import petros.efthymiou.groovy.utils.captureValues
import petros.efthymiou.groovy.utils.getValueForTest

class PlaylistsViewModelShould : BaseUnitTest() {

    private lateinit var viewModel: PlaylistsViewModel
    private val mockRepository: PlaylistsRepository = mockk()
    private val mockPlayList = mockk<List<Playlists>>()
    private val expected = Result.success(mockPlayList)
    private val exception = RuntimeException("Something went wrong")

    @Test
    private fun getPlaylistsFromTheRepository() {
        viewModel = mockSuccessfulCase()
        runBlocking {
            viewModel.playlists.getValueForTest()

            coVerify(exactly = 1) { mockRepository.getPlaylists() }
        }
    }

    @Test
    private fun emitsPlaylistsFromRepository() {
        viewModel = mockSuccessfulCase()
        runBlocking {
            assertEquals(expected, viewModel.playlists.getValueForTest())
        }
    }

    @Test
    private fun emitErrorWhenReceiveError() {
        runBlocking {
            viewModel = mockErrorCase()
            assertEquals(exception, viewModel.playlists.getValueForTest()!!.exceptionOrNull())
        }

    }

    @Test
    private fun showProgressBarWhileLoading() {
        runBlocking {
            viewModel = mockSuccessfulCase()
            viewModel.loader.captureValues {
                viewModel.playlists.getValueForTest()
                assertEquals(true, values[0])
            }
        }
    }

    @Test
    private fun hideProgressBarAfterPlaylistsFetchIsCompleted() {
        runBlocking {
            viewModel = mockSuccessfulCase()
            viewModel.loader.captureValues {
                viewModel.playlists.getValueForTest()
                assertEquals(false, values.last())
            }
        }
    }

    @Test
    private fun hideProgressBarAfterError() {
        runBlocking {
            viewModel = mockErrorCase()
            viewModel.loader.captureValues {
                viewModel.playlists.getValueForTest()
                assertEquals(false, values.last())
            }
        }
    }

    private fun mockErrorCase(): PlaylistsViewModel {
        return runBlocking {
            coEvery { mockRepository.getPlaylists() } returns flow {
                emit(Result.failure(exception))
            }
            PlaylistsViewModel(mockRepository)
        }
    }

    private fun mockSuccessfulCase(): PlaylistsViewModel {
        runBlocking {
            coEvery { mockRepository.getPlaylists() } returns flow {
                emit(expected)
            }
        }
        return PlaylistsViewModel(mockRepository)
    }
}