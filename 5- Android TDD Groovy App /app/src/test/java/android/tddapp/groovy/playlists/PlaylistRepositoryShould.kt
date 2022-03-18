package android.tddapp.groovy.playlists

import android.tddapp.groovy.utils.BaseUnitTest
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistRepositoryShould : BaseUnitTest() {

    private val playlistsService: PlaylistsService = spyk()
    private val repository = PlaylistsRepository(playlistsService)

    @Test
    fun getPlayListsFromService() {
        runBlocking {
            repository.getPlaylists()
            coVerify(exactly = 1) { playlistsService.fetchPlaylists() }
        }
    }
}