package android.tddapp.groovy

import android.tddapp.groovy.utils.MainCoroutineScopeRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import petros.efthymiou.groovy.utils.getValueForTest

class PlaylistViewModelShould {

    @get:Rule
    val coroutinesTestRule = MainCoroutineScopeRule()

    /*
     InstantTaskExecutorRule is coming from livedata
     This rule allowing the execution of the live data to happen instantly so we can use the values
     in our test
     */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: PlaylistViewModel
    private val mockRepository: PlaylistsRepository = spyk()

    private val mockPlayList = mockk<List<Playlist>>()
    private val expected = Result.success(mockPlayList)

    @Before
    fun setup() {
        runBlocking {
            coEvery { mockRepository.getPlaylists() } returns flow {
                emit(expected)
            }
        }
        viewModel = PlaylistViewModel(mockRepository)
    }

    @Test
    fun getPlaylistsFromTheRepository() {
        runBlocking {
            viewModel.playlists.getValueForTest()

            coVerify(exactly = 1) { mockRepository.getPlaylists() }
        }

    }

    @Test
    fun emitsPlaylistsFromRepository() {
        runBlocking {
            assertEquals(expected, viewModel.playlists.getValueForTest())
        }

    }
}