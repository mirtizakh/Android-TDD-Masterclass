package android.tddapp.groovy

import android.tddapp.groovy.utils.MainCoroutineScopeRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
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

    private val viewModel : PlaylistViewModel
    val mockRepository : PlaylistsRepository = mock()

    init {
        viewModel = PlaylistViewModel()


    }
    @Test
    fun getPlaylistsFromTheRepository() {
        viewModel.playlists.getValueForTest()

        verify(mockRepository,times(1)).getPlaylists()
    }
}