package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaylistsRepository @Inject constructor(
    private val service: PlaylistsService
) {
    suspend fun getPlaylists(): Flow<Result<List<Playlists>>> {
        return service.fetchPlaylists()
    }

}
