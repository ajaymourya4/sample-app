package com.ajaymourya.android.network.responses

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Test

class PageResponseTest {

    @Test
    fun createPageResponse_ShouldAddCorrectAttributes() {
        val page = 1
        val totalPages = 100
        val totalResults = 5000
        val results: List<String> = mockk()

        val pageResponse = PageResponse(
            page = page,
            totalPages = totalPages,
            totalResults = totalResults,
            results = results
        )

        assertThat(page).isEqualTo(pageResponse.page)
        assertThat(totalPages).isEqualTo(pageResponse.totalPages)
        assertThat(totalResults).isEqualTo(pageResponse.totalResults)
        assertThat(results).isEqualTo(pageResponse.results)
    }
}
