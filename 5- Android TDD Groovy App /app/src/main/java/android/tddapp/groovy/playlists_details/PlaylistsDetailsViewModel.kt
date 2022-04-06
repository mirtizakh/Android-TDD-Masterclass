package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.playlists.PlaylistsRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PlaylistsDetailsViewModel(
    private val repository: PlaylistsRepository
) : ViewModel() {

    val playlistsDetails: MutableLiveData<Result<PlaylistsDetails>> = MutableLiveData()
    fun getPlaylistsDetails(id: String) {

    }

}
