package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.playlists.PlaylistsAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistsDetailsService @Inject constructor(
    private val playlistsAPI: PlaylistsAPI){

    suspend fun fetchPlaylistsDetails(id: String): Flow<Result<PlaylistsDetails>>  {
        return flow {
            emit(Result.success(playlistsAPI.fetchPlaylistsDetails()))
        }
            .catch {
                emit(Result.failure(RuntimeException("Network exception")))
            }
    }

}
