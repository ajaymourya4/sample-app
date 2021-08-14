package com.ajaymourya.android.network.services

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Representation interface of the TMDB API endpoints
 */
interface MovieService {

    @GET("trending/movie/week")
    fun getWeeklyTrendingMovies(@Query("api_key") apiKey: String)
}
