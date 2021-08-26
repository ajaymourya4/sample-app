package com.ajaymourya.android.network.repositories

import com.ajaymourya.android.BuildConfig
import com.ajaymourya.android.network.services.MovieService
import timber.log.Timber
import javax.inject.Inject

private const val TMDB_API_KEY = BuildConfig.TMDB_API_KEY

class MovieRepository @Inject constructor(val movieService: MovieService) {

    suspend fun get(): Any {

        val result = movieService.getWeeklyTrendingMovies(
            apiKey = TMDB_API_KEY
        )
        Timber.e("RESULT ${result.body()!!}")
        return result.body()!!
    }
}
