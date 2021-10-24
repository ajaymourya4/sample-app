package com.ajaymourya.android.network.responses

import com.ajaymourya.android.ui.list.model.MovieItem
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val id: Long,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val video: Boolean,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val popularity: Double,
    @SerializedName("media_type")
    val mediaType: String
)

fun List<MovieResponse>.toMovieItemList() = this.map {
    MovieItem(
        id = it.id,
        title = it.title,
        overview = it.overview,
        releaseDate = it.releaseDate,
        posterPath = it.posterPath
    )
}
