package com.ajaymourya.android.network.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ajaymourya.android.BuildConfig
import com.ajaymourya.android.network.services.MovieService
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

private const val API_PUBLIC_KEY = BuildConfig.TMDB_API_KEY

class MovieRepositoryTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    lateinit var movieService: MovieService
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        movieRepository = MovieRepository(movieService)
    }

    @Test
    fun getTrendingMovies() = runBlocking<Unit> {
        val apiKey = slot<String>()

        movieRepository.getTrendingMovies()

        coVerify {
            movieService.getWeeklyTrendingMovies(
                apiKey = capture(apiKey)
            )
        }

        assertThat(API_PUBLIC_KEY).isEqualTo(apiKey.captured)
    }
}
