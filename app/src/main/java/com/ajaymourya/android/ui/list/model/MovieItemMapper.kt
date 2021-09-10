package com.ajaymourya.android.ui.list.model

import com.ajaymourya.android.mapper.Mapper
import com.ajaymourya.android.network.responses.MovieResponse
import com.ajaymourya.android.network.responses.PageResponse

class MovieItemMapper : Mapper<PageResponse<MovieResponse>, List<MovieItem>> {

    override suspend fun map(from: PageResponse<MovieResponse>): List<MovieItem> {
        return from.results.map {
            MovieItem(
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath
            )
        }
    }
}

fun PageResponse<MovieResponse>.toMovieItemList() = results.map {
    MovieItem(
        title = it.title,
        overview = it.overview,
        releaseDate = it.releaseDate,
        posterPath = it.posterPath
    )
}
