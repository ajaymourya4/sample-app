package com.ajaymourya.android.network.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ajaymourya.android.BuildConfig
import com.ajaymourya.android.network.responses.toMovieItemList
import com.ajaymourya.android.network.services.MovieService
import com.ajaymourya.android.ui.list.model.MovieItem
import retrofit2.HttpException
import java.io.IOException

private const val MOVIE_STARTING_PAGE_INDEX = 1

class MoviePagingSource(private val movieService: MovieService) : PagingSource<Int, MovieItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        val position = params.key ?: MOVIE_STARTING_PAGE_INDEX
        return try {
            val response = movieService.getWeeklyTrendingMovies(BuildConfig.TMDB_API_KEY, position)
            val movies = response.results.toMovieItemList()
            LoadResult.Page(
                data = movies,
                prevKey = if (position == MOVIE_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (movies.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
