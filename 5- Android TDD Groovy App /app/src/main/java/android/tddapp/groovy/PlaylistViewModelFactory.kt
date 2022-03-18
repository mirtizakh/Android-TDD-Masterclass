package android.tddapp.groovy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlaylistViewModelFactory
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(
                PlaylistViewModel::class.java)) {

            return PlaylistViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}