package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException

class PlaylistsService(
    private val playlistsAPI: PlaylistsAPI
) {
    suspend fun fetchPlaylists(): Flow<Result<List<Playlists>>> {

        return flow { emit(Result.success(playlistsAPI.fetchAllPlaylists())) }
            .catch {
                emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

}
