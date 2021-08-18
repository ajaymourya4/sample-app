package com.ajaymourya.android.network.responses

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Test

class MovieResponseTest {

    @Test
    fun createMovieResponse_ShouldAddCorrectAttributes() {
        val title = "title"
        val voteAverage = 9.8f
        val overview = "overview"
        val releaseDate = "releaseDate"
        val id = 10101L
        val adult = false
        val backdropPath = "backdropPath"
        val voteCount = 10
        val genreIds: List<Int> = mockk()
        val video = true
        val originalLanguage = "originalLanguage"
        val originalTitle = "originalTitle"
        val posterPath = "posterPath"
        val popularity = 450.3345
        val mediaType = "mediaType"

        val movieResponse = MovieResponse(
            title = title,
            voteAverage = voteAverage,
            overview = overview,
            releaseDate = releaseDate,
            id = id,
            adult = adult,
            backdropPath = backdropPath,
            voteCount = voteCount,
            genreIds = genreIds,
            video = video,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            posterPath = posterPath,
            popularity = popularity,
            mediaType = mediaType
        )

        assertThat(title).isEqualTo(movieResponse.title)
        assertThat(voteAverage).isEqualTo(movieResponse.voteAverage)
        assertThat(overview).isEqualTo(movieResponse.overview)
        assertThat(releaseDate).isEqualTo(movieResponse.releaseDate)
        assertThat(id).isEqualTo(movieResponse.id)
        assertThat(adult).isEqualTo(movieResponse.adult)
        assertThat(backdropPath).isEqualTo(movieResponse.backdropPath)
        assertThat(voteCount).isEqualTo(movieResponse.voteCount)
        assertThat(genreIds).isEqualTo(movieResponse.genreIds)
        assertThat(video).isEqualTo(movieResponse.video)
        assertThat(originalLanguage).isEqualTo(movieResponse.originalLanguage)
        assertThat(originalTitle).isEqualTo(movieResponse.originalTitle)
        assertThat(posterPath).isEqualTo(movieResponse.posterPath)
        assertThat(popularity).isEqualTo(movieResponse.popularity)
        assertThat(mediaType).isEqualTo(movieResponse.mediaType)
    }
}
