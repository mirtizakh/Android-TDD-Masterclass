package android.tddapp.groovy.playlists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData

class PlaylistsViewModel(
    private val repository: PlaylistsRepository
) : ViewModel() {

    // We are using live data builder here
    val playlists = liveData<Result<List<Playlists>>> {
        emitSource(repository.getPlaylists().asLiveData())
    }


/*  The above line of code is similar like this code below

    val playlists = MutableLiveData<Result<List<Playlist>>>()
    init {
        viewModelScope.launch {
            repository.getPlaylists()
                .collect {
                    playlists.value = it
                }
        }
    }
 */

}
