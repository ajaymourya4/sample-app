package com.ajaymourya.android.network.repositories

import com.ajaymourya.android.BuildConfig
import com.ajaymourya.android.network.responses.MovieResponse
import com.ajaymourya.android.network.responses.PageResponse
import com.ajaymourya.android.network.services.MovieService
import javax.inject.Inject

private const val TMDB_API_KEY = BuildConfig.TMDB_API_KEY

class MovieRepository @Inject constructor(val movieService: MovieService) {

    suspend fun getTrendingMovies(): PageResponse<MovieResponse> {
        val result = movieService.getWeeklyTrendingMovies(
            apiKey = TMDB_API_KEY
        )
        return result.body()!!
    }
}
