package android.tddapp.groovy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlaylistViewModel : ViewModel(){

    val playlists =  MutableLiveData<List<Playlist>>()
}
