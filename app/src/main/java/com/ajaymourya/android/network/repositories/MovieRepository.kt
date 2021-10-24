package com.ajaymourya.android.network.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ajaymourya.android.BuildConfig
import com.ajaymourya.android.network.responses.MovieResponse
import com.ajaymourya.android.network.responses.PageResponse
import com.ajaymourya.android.network.services.MovieService
import com.ajaymourya.android.ui.list.model.MovieItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val TMDB_API_KEY = BuildConfig.TMDB_API_KEY

class MovieRepository @Inject constructor(val movieService: MovieService) {

    suspend fun getTrendingMovies(): PageResponse<MovieResponse> {
        val result = movieService.getWeeklyTrendingMovies(
            apiKey = TMDB_API_KEY,
            page = 1
        )
        return result
    }

    fun getPaginatedTrendingMovies(): Flow<PagingData<MovieItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(movieService) }
        ).flow
    }
}
