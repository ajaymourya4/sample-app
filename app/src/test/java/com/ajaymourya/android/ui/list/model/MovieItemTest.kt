package com.ajaymourya.android.ui.list.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MovieItemTest {

    @Test
    fun createMovieItem_ShouldAddCorrectAttributes() {
        val title = "title"
        val overview = "overview"
        val releaseDate = "releaseDate"
        val posterPath = "posterPath"

        val movieItem = MovieItem(
            title = title,
            overview = overview,
            releaseDate = releaseDate,
            posterPath = posterPath
        )

        assertThat(title).isEqualTo(movieItem.title)
        assertThat(overview).isEqualTo(movieItem.overview)
        assertThat(releaseDate).isEqualTo(movieItem.releaseDate)
        assertThat(posterPath).isEqualTo(movieItem.posterPath)
    }
}
