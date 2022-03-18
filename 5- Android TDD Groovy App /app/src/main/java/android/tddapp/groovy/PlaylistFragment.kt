package android.tddapp.groovy

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner

class PlaylistFragment : Fragment() {

    lateinit var playlistViewModel : PlaylistViewModel
    lateinit var playlistViewModelFactory : PlaylistViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)

        playlistViewModel.playlists.observe(this as LifecycleOwner , {playlists ->
            with(view as RecyclerView) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyPlaylistRecyclerViewAdapter(playlists)
            }
        })
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PlaylistFragment().apply {}
    }
}