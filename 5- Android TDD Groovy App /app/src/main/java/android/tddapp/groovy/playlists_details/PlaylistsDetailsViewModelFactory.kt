package android.tddapp.groovy.playlists_details

import android.tddapp.groovy.playlists.PlaylistsRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PlaylistsDetailsViewModelFactory @Inject constructor(
    private val service: PlaylistsDetailsService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(
                PlaylistsDetailsViewModel::class.java
            )
        ) {
            return PlaylistsDetailsViewModel(service) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
