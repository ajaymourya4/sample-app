package com.ajaymourya.android.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Representation interface of the TMDB API endpoints
 */
interface MovieService {

    @GET("trending/movie/week")
    suspend fun getWeeklyTrendingMovies(@Query("api_key") apiKey: String): Response<Any>
}
