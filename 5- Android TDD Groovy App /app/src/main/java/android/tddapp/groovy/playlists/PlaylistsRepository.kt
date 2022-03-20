package android.tddapp.groovy.playlists

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistsRepository @Inject constructor(
    private val service: PlaylistsService,
    private val playListsMapper: PlayListsMapper
) {
    suspend fun getPlaylists(): Flow<Result<List<Playlists>>> =
        service.fetchPlaylists().map { result ->
            if (result.isSuccess) {
                Result.success(playListsMapper.invoke(result.getOrNull()!!))
            } else {
                Result.failure(result.exceptionOrNull()!!)
            }

        }

}
