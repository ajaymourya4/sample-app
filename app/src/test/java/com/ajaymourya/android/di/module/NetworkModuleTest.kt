package com.ajaymourya.android.di.module

import com.ajaymourya.android.BuildConfig
import com.ajaymourya.android.network.services.MovieService
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule

    @Before
    fun setUp() {
        networkModule = NetworkModule()
    }

    @Test
    fun verifyProvidedLoggingInterceptor() {
        val interceptor = networkModule.provideHttpLoggingInterceptor()
        assertThat(HttpLoggingInterceptor.Level.BODY).isEqualTo(interceptor.level)
    }

    @Test
    fun verifyProvidedHttpClient() {
        val interceptor = mockk<HttpLoggingInterceptor>()
        val httpClient = networkModule.provideHttpClient(interceptor)

        assertThat(1).isEqualTo(httpClient.interceptors.size)
        assertThat(interceptor).isEqualTo(httpClient.interceptors.first())
    }

    @Test
    fun verifyProvidedRetrofitBuilder() {
        val httpClient = mockk<OkHttpClient>()
        val retrofit = networkModule.provideRetrofitBuilder(httpClient)

        assertThat(BuildConfig.TMDB_API_BASE_URL).isEqualTo(retrofit.baseUrl().toString())
    }

    @Test
    fun verifyProvidedMovieService() {
        val retrofit = mockk<Retrofit>()
        val movieService = mockk<MovieService>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<MovieService>(any()) } returns movieService

        networkModule.provideMovieService(retrofit)
        verify { retrofit.create(capture(serviceClassCaptor)) }

        assertThat(MovieService::class.java).isEqualTo(serviceClassCaptor.captured)
    }
}
