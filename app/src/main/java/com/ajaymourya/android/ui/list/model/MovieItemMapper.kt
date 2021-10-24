package com.ajaymourya.android.ui.list.model

import com.ajaymourya.android.network.responses.MovieResponse
import com.ajaymourya.android.network.responses.PageResponse

fun PageResponse<MovieResponse>.toMovieItemList() = results.map {
    MovieItem(
        id = it.id,
        title = it.title,
        overview = it.overview,
        releaseDate = it.releaseDate,
        posterPath = it.posterPath
    )
}
