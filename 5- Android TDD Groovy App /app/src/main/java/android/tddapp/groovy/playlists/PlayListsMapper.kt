package android.tddapp.groovy.playlists

import javax.inject.Inject

class PlayListsMapper @Inject constructor() : Function1<List<PlaylistsRaw>, List<Playlists>> {
    override fun invoke(playlistsRaw: List<PlaylistsRaw>): List<Playlists> {
        return playlistsRaw.map { value ->
            Playlists(value.id, "", "", 1)
        }
    }
}
