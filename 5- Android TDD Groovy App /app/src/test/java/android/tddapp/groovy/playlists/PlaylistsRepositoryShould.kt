package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistsRepositoryShould : BaseUnitTest() {

    private val mockService: PlaylistsService = mockk(relaxed = true)
    private val mockPlayLists = mockk<List<Playlists>>()
    private val mockPlayListsRaw = mockk<List<PlaylistsRaw>>()
    private val mockPlayListsMapper = mockk<PlayListsMapper>(relaxed = true)
    private val expectedPlayListsRaw = Result.success(mockPlayListsRaw)
    private val expectedPlayLists = Result.success(mockPlayLists)
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getPlayListsFromService() {
        runBlocking {
            val repository = PlaylistsRepository(mockService, mockPlayListsMapper)
            repository.getPlaylists()
            coVerify(exactly = 1) { mockService.fetchPlaylists() }
        }
    }

    @Test
    fun emitsPlaylistsFromService() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(expectedPlayListsRaw)
            }

            coEvery { mockPlayListsMapper.invoke(mockPlayListsRaw) } returns mockPlayLists

            val repository = PlaylistsRepository(mockService, mockPlayListsMapper)
            TestCase.assertEquals(expectedPlayLists, repository.getPlaylists().first())
        }
    }

    /* We are testing the same scenario as in above method but with
       list expected
    */
    @Test
    fun emitsPlaylistsFromServiceWithExpectedList() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(Result.success(mockPlayListsRaw))
            }

            coEvery { mockPlayListsMapper.invoke(mockPlayListsRaw) } returns mockPlayLists

            val repository = PlaylistsRepository(mockService, mockPlayListsMapper)
            TestCase.assertEquals(mockPlayLists, repository.getPlaylists().first().getOrNull())
        }
    }

    @Test
    fun propagateErrors() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(Result.failure(exception))
            }

            val repository = PlaylistsRepository(mockService, mockPlayListsMapper)
            TestCase.assertEquals(
                exception,
                repository.getPlaylists().first().exceptionOrNull()
            )
        }
    }

    @Test
    fun delegateBusinessLogicToMapper() {
        runBlocking {
            coEvery { mockService.fetchPlaylists() } returns flow {
                emit(Result.success(mockPlayListsRaw))
            }
            val repository = PlaylistsRepository(mockService, mockPlayListsMapper)
            repository.getPlaylists().first()
            coVerify(exactly = 1) { mockPlayListsMapper.invoke(mockPlayListsRaw) }

        }
    }
}