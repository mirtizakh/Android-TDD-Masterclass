package android.tddapp.groovy.playlists_details

import android.os.Bundle
import android.tddapp.groovy.PlaylistsDetailsFragmentArgs
import android.tddapp.groovy.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_playlists_details.*
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

        observePlaylistLoader()

        observePlaylistsDetails(rootView)

        return rootView
    }

    private fun observePlaylistsDetails(rootView: View) {
        viewModel.playlistsDetails.observe(this as LifecycleOwner) { playlistsDetails ->
            if (playlistsDetails.getOrNull() != null) {
                setupUI(rootView, playlistsDetails)
            } else {
                Snackbar.make(rootView, R.string.generic_error, Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun setupUI(
        rootView: View,
        playlistsDetails: Result<PlaylistsDetails>
    ) {
        playlistsDetails.getOrNull()?.let {
            playlists_name.text = it.name
            playlists_details.text = it.details
        }

    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(
                this,
                playlistDetailsViewModelFactory
            ).get(PlaylistsDetailsViewModel::class.java)
    }

    private fun observePlaylistLoader() {
        viewModel.loader.observe(this as LifecycleOwner) { loading ->
            details_loader.isVisible = loading
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PlaylistsDetailsFragment()
    }

}