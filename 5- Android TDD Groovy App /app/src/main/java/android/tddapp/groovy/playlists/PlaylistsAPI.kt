package android.tddapp.groovy.playlists

import android.tddapp.groovy.playlists_details.PlaylistsDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaylistsAPI {

    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<PlaylistsRaw>

    @GET("playlists-details/{id}")
    suspend fun fetchPlaylistsDetails(@Path("id") id: String): PlaylistsDetails

}
