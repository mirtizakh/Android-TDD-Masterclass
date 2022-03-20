package android.tddapp.groovy.playlists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.onEach

class PlaylistsViewModel(
    private val repository: PlaylistsRepository
) : ViewModel() {

    val loader = MutableLiveData<Boolean>()

    // We are using live data builder here
    val playlists = liveData<Result<List<Playlists>>> {
        loader.postValue(true)
        emitSource(repository.getPlaylists().
        onEach {
            loader.postValue(false)
        }.asLiveData())
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
