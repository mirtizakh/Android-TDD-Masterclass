package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaylistsService(
    private val playlistsAPI: PlaylistsAPI
) {
    suspend fun fetchPlaylists(): Flow<Result<List<Playlists>>> {

        return flow { emit(Result.success(playlistsAPI.fetchAllPlaylists())) }
    }

}
