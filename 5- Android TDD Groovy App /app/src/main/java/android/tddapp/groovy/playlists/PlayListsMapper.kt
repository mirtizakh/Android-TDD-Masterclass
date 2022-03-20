package android.tddapp.groovy.playlists

import android.tddapp.groovy.R
import javax.inject.Inject

class PlayListsMapper @Inject constructor() : Function1<List<PlaylistsRaw>, List<Playlists>> {
    override fun invoke(playlistsRaw: List<PlaylistsRaw>): List<Playlists> {
        return playlistsRaw.map { value ->
            val image = when (value.category) {
                "rock" -> R.drawable.rock
                else -> R.mipmap.playlist
            }

            Playlists(value.id, value.name, value.category, image)
        }
    }
}
