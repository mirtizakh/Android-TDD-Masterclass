package android.tddapp.groovy.playlists

import retrofit2.http.GET

interface PlaylistsAPI {

    @GET("playlists")
    fun fetchAllPlaylists() : List<Playlists>

}
