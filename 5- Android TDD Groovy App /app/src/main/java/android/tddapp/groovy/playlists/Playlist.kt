package android.tddapp.groovy.playlists

import android.tddapp.groovy.R

data class Playlist(
    val id: String,
    val name: String,
    val category: String,
    val image: Int = R.mipmap.playlist
)
