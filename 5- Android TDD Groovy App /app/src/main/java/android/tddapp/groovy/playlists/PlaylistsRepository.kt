package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow

class PlaylistsRepository(
    private val service: PlaylistsService
) {
    suspend fun getPlaylists(): Flow<Result<List<Playlist>>> {
        return service.fetchPlaylists()
    }

}
