package android.tddapp.groovy.playlists_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class PlaylistsDetailsViewModel(
    private val service: PlaylistsDetailsService
) : ViewModel() {

    val loader = MutableLiveData<Boolean>()
    val playlistsDetails: MutableLiveData<Result<PlaylistsDetails>> = MutableLiveData()

    fun getPlaylistsDetails(id: String) {
        viewModelScope.launch {
            loader.postValue(true)
            service.fetchPlaylistsDetails(id)
                .onEach {
                    loader.postValue(false)
                }
                .collect {
                    playlistsDetails.postValue(it)
                }
        }
    }
}
