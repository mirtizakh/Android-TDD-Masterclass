package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistsRepositoryShould : BaseUnitTest() {

    private val mockService: PlaylistsService = spyk()
    private val mockPlayList = mockk<List<Playlists>>()
    private val expected = Result.success(mockPlayList)
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getPlayListsFromService() {
        runBlocking {
            val repository = PlaylistsRepository(mockService)
            repository.getPlaylists()
            coVerify(exactly = 1) { mockService.fetchPlaylists() }
        }
    }

    @Test
    fun emitsPlaylistsFromService() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(expected)
            }
            val repository = PlaylistsRepository(mockService)
            TestCase.assertEquals(expected, repository.getPlaylists().first())
        }
    }

    // We are testing the same scenario as in above method but with list expected
    @Test
    fun emitsPlaylistsFromServiceWithExpectedList() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(Result.success(mockPlayList))
            }
            val repository = PlaylistsRepository(mockService)
            TestCase.assertEquals(mockPlayList, repository.getPlaylists().first().getOrNull())
        }
    }

    @Test
    fun propagateErrors() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(Result.failure(exception))
            }

            val repository = PlaylistsRepository(mockService)
            TestCase.assertEquals(
                exception,
                repository.getPlaylists().first().exceptionOrNull()
            )
        }

    }
}