package android.tddapp.groovy.playlists

import android.tddapp.groovy.R
import junit.framework.TestCase.assertEquals
import org.junit.Test

class PlaylistsMapperShould {

    private val playlistsRaw = PlaylistsRaw("1", "Hard Rock Cafe", "house")
    private val playlistsRawRock = PlaylistsRaw("1", "Hard Rock Cafe", "rock")

    private val playlistsMapper = PlayListsMapper()

    private val playlists = playlistsMapper(listOf(playlistsRaw))

    private val singlePlaylist = playlists[0]
    private val singlePlaylistRock = playlistsMapper(listOf(playlistsRawRock))[0]

    @Test
    fun keepSamePlaylistsId() {
        assertEquals(playlistsRaw.id, singlePlaylist.id)
    }

    @Test
    fun keepSamePlaylistsName() {
        assertEquals(playlistsRaw.name, singlePlaylist.name)
    }

    @Test
    fun keepSamePlaylistsCategory() {
        assertEquals(playlistsRaw.category, singlePlaylist.category)
    }

    @Test
    fun mapDefaultImageWhenCategoryIsNotRock() {
        assertEquals(R.mipmap.playlist, singlePlaylist.image)
    }

    @Test
    fun mapRockImageWhenCategoryIsNotRock() {
        assertEquals(R.drawable.rock, singlePlaylistRock.image)
    }
}