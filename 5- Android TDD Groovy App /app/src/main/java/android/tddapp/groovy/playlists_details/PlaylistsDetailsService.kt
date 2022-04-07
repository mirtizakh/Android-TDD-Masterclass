package android.tddapp.groovy.playlists_details

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistsDetailsService @Inject constructor(){
   suspend fun fetchPlaylistsDetails(id: String) : Flow<Result<PlaylistsDetails>> {
      return flow {  }
    }

}
