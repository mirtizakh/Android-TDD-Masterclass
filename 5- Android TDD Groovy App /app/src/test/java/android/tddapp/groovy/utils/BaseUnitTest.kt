package android.tddapp.groovy.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

open class BaseUnitTest {
    @get:Rule
    val coroutinesTestRule = MainCoroutineScopeRule()

    /*
     InstantTaskExecutorRule is coming from livedata
     This rule allowing the execution of the live data to happen instantly so we can use the values
     in our test
     */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}