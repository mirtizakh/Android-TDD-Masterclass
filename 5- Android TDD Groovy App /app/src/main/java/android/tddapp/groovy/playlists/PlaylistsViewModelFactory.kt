package android.tddapp.groovy.playlists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PlaylistsViewModelFactory @Inject constructor(
    private val repository: PlaylistsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(
                PlaylistsViewModel::class.java
            )
        ) {

            return PlaylistsViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}