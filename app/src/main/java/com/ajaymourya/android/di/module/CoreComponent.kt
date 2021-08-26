package com.ajaymourya.android.di.module

import android.content.Context
import com.ajaymourya.android.network.repositories.MovieRepository
import com.ajaymourya.android.network.services.MovieService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface CoreComponent {

    fun context(): Context

    fun movieService(): MovieService

    fun movieRepository(): MovieRepository
}
