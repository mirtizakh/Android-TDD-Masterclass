package android.tddapp.groovy.playlists

import javax.inject.Inject

class PlayListsMapper @Inject constructor() : Function1<List<PlaylistsRaw>, List<Playlists>> {
    override fun invoke(p1: List<PlaylistsRaw>): List<Playlists> {
        return listOf()
    }
}
