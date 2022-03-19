package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaylistsService {
    suspend fun fetchPlaylists(): Flow<Result<List<Playlist>>> {
        return flow { }
    }

}
