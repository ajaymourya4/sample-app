package com.ajaymourya.android.network.services

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MockResponses {
    const val GET_TRENDING_MOVIES = "mock-responses/get-trending-movies-response.json"
}

class MovieServiceTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var service: MovieService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun requestGetTrendingMovies() = runBlocking<Unit> {
        enqueueResponse(MockResponses.GET_TRENDING_MOVIES)
        val apiKey = "mockApiKey"
        service.getWeeklyTrendingMovies(apiKey = apiKey)

        val request = mockWebServer.takeRequest()
        assertThat("GET").isEqualTo(request.method)
        assertThat("/trending/movie/week?api_key=$apiKey").isEqualTo(request.path)
    }

    @Test
    fun responseGetTrendingMovies_status200() = runBlocking<Unit> {
        enqueueResponse(MockResponses.GET_TRENDING_MOVIES, 200)
        val page = 1
        val totalPages = 1000
        val totalResults = 20000
        val response = service.getWeeklyTrendingMovies(apiKey = "")

        assertThat(200).isEqualTo(response.code())
        assertNotNull(response.body())

        val responseData = response.body()!!
        assertThat(page).isEqualTo(responseData.page)
        assertThat(totalPages).isEqualTo(responseData.totalPages)
        assertThat(totalResults).isEqualTo(responseData.totalResults)
        assertThat(responseData.results).isInstanceOf(List::class.java)
    }

    @Test
    fun responseGetTrendingMovies_status401() = runBlocking<Unit> {
        enqueueResponse(MockResponses.GET_TRENDING_MOVIES, 401)
        val response = service.getWeeklyTrendingMovies(apiKey = "")

        assertThat(401).isEqualTo(response.code())
        assertNull(response.body())
    }

    private fun enqueueResponse(filePath: String, responseCode: Int = 200) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
        val bufferSource = inputStream?.source()?.buffer()
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(responseCode)

        mockWebServer.enqueue(
            mockResponse.setBody(bufferSource!!.readString(Charsets.UTF_8))
        )
    }
}
