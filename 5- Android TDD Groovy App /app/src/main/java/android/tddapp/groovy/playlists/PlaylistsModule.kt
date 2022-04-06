package android.tddapp.groovy.playlists

import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// We need to add this because for testing we want to wait unless the data will be fetched from the API.
val client = OkHttpClient()
val idlingResource = OkHttp3IdlingResource.create("okhttp", client)

@Module
@InstallIn(FragmentComponent::class)
class PlaylistsModule {

    @Provides
    fun playlistsAPI(retrofit: Retrofit): PlaylistsAPI = retrofit.create(PlaylistsAPI::class.java)

    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.169:3000/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}