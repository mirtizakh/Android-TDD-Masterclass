package android.tddapp.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlaylistViewModel(
    private val repository: PlaylistsRepository
) : ViewModel(){

    init {
        repository.getPlaylists()
    }
    val playlists =  MutableLiveData<Result<List<Playlist>>>()
}
