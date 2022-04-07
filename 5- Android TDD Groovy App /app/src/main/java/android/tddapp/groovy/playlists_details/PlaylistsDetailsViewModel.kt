package android.tddapp.groovy.playlists_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class PlaylistsDetailsViewModel(
    private val service: PlaylistsDetailsService
) : ViewModel() {

    val playlistsDetails: MutableLiveData<Result<PlaylistsDetails>> = MutableLiveData()
    fun getPlaylistsDetails(id: String) {
        viewModelScope.launch {
            service.fetchPlaylistsDetails(id)
                .collect{
                    playlistsDetails.postValue(it)
                }

        }

    }

}
