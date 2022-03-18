package android.tddapp.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PlaylistViewModel(
    private val repository: PlaylistsRepository
) : ViewModel() {

    val playlists = MutableLiveData<Result<List<Playlist>>>()

    init {
        viewModelScope.launch {
            repository.getPlaylists()
                .collect {
                    playlists.value = it
                }
        }

    }

}
