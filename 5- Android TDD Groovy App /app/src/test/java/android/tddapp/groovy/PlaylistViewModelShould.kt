package android.tddapp.groovy

import android.tddapp.groovy.utils.MainCoroutineScopeRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.spyk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import petros.efthymiou.groovy.utils.getValueForTest

class PlaylistViewModelShould {

    @get:Rule
    val coroutinesTestRule = MainCoroutineScopeRule()

    /*
     InstantTaskExecutorRule is coming from livedata
     This rule allowing the execution of the live data to happen instantly so we can use the values
     in our test
     */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel: PlaylistViewModel
    private val mockRepository: PlaylistsRepository = spyk()

    init {
        viewModel = PlaylistViewModel(mockRepository)
    }

    @Test
    fun getPlaylistsFromTheRepository() {
        viewModel.playlists.getValueForTest()

        verify(exactly = 1) { mockRepository.getPlaylists() }
    }
}