package android.tddapp.groovy.playlists

import retrofit2.http.GET

interface PlaylistsAPI {

    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<Playlists>

}
