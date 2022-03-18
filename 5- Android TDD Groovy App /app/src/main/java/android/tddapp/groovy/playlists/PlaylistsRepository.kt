package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaylistsRepository(
    private val service: PlaylistsService
) {
    suspend fun getPlaylists() : Flow<Result<List<Playlist>>>{
        service.fetchPlaylists()
        return flow {  }
    }

}
