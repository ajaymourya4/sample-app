package com.ajaymourya.android.ui.list.model

import com.ajaymourya.android.network.responses.MovieResponse
import com.ajaymourya.android.network.responses.PageResponse
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MovieItemMapperTest {

    @Test
    fun movieItemMapper_WithEmptyResults_shouldReturnEmptyList() {
        val response = PageResponse<MovieResponse>(
            page = 1,
            totalPages = 100,
            totalResults = 1000,
            results = emptyList()
        )

        assertThat(response.toMovieItemList()).isEmpty()
    }

    @Test
    fun movieItemMapper_WithResults_ShouldReturnParsedList() {
        val movieResponseItem = MovieResponse(
            title = "title",
            voteAverage = 9.8f,
            overview = "overview",
            releaseDate = "releaseDate",
            id = 10101L,
            adult = false,
            backdropPath = "backdropPath",
            voteCount = 10,
            genreIds = mockk(),
            video = true,
            originalLanguage = "originalLanguage",
            originalTitle = "originalTitle",
            posterPath = "posterPath",
            popularity = 450.3345,
            mediaType = "mediaType",
        )
        val response = PageResponse<MovieResponse>(
            page = 1,
            totalPages = 100,
            totalResults = 1000,
            results = listOf(
                movieResponseItem
            )
        )

        response.toMovieItemList().first().run {
            assertThat(movieResponseItem.title).isEqualTo(this.title)
            assertThat(movieResponseItem.overview).isEqualTo(this.overview)
            assertThat(movieResponseItem.releaseDate).isEqualTo(this.releaseDate)
            assertThat(movieResponseItem.posterPath).isEqualTo(this.posterPath)
        }
    }
}
