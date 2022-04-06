package android.tddapp.groovy.playlists_details

import android.os.Bundle
import android.tddapp.groovy.PlaylistsDetailsFragmentArgs
import android.tddapp.groovy.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlaylistsDetailsFragment : Fragment() {

    lateinit var viewModel: PlaylistsDetailsViewModel

    @Inject
    lateinit var playlistDetailsViewModelFactory: PlaylistsDetailsViewModelFactory

    val args: PlaylistsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_playlists_details, container, false)

        val id = args.playlistsId

        setupViewModel()

        viewModel.getPlaylistsDetails(id)

        viewModel.playlistsDetails.observe(this as LifecycleOwner) { playlistsDetails ->
            if (playlistsDetails.getOrNull() != null) {
                rootView.findViewById<TextView>(R.id.playlists_name).text =
                    playlistsDetails.getOrNull()!!.name
                rootView.findViewById<TextView>(R.id.playlists_details).text =
                    playlistsDetails.getOrNull()!!.details
            } else {
                // TODO
            }
        }

        return rootView
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(
                this,
                playlistDetailsViewModelFactory
            ).get(PlaylistsDetailsViewModel::class.java)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PlaylistsDetailsFragment()
    }

}