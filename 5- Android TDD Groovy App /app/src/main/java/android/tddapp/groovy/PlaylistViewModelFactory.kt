package android.tddapp.groovy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlaylistViewModelFactory(
    private val repository: PlaylistsRepository
)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(
                PlaylistViewModel::class.java)) {

            return PlaylistViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}