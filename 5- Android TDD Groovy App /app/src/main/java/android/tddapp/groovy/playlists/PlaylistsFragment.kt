package android.tddapp.groovy.playlists

import android.os.Bundle
import android.tddapp.groovy.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaylistsFragment : Fragment() {

    lateinit var playlistViewModel: PlaylistsViewModel
    lateinit var playlistViewModelFactory: PlaylistsViewModelFactory

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:3000/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(PlaylistsAPI::class.java)
    private val service = PlaylistsService(api)
    private val repository = PlaylistsRepository(service)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)

        setupViewModel()

        playlistViewModel.playlists.observe(this as LifecycleOwner) { playlists ->
            if (playlists.getOrNull() != null)
                setupAdapter(view, playlists.getOrNull()!!)
            else {
                // TODO
            }
        }
        return view
    }

    private fun setupAdapter(
        view: View?,
        playlists: List<Playlists>
    ) {
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyPlaylistsRecyclerViewAdapter(playlists)
        }
    }

    private fun setupViewModel() {
        playlistViewModelFactory = PlaylistsViewModelFactory(repository)
        playlistViewModel =
            ViewModelProvider(this, playlistViewModelFactory).get(PlaylistsViewModel::class.java)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PlaylistsFragment().apply {}
    }
}