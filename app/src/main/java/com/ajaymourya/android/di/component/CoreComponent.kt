package com.ajaymourya.android.di.component

import android.content.Context
import com.ajaymourya.android.di.module.ContextModule
import com.ajaymourya.android.di.module.NetworkModule
import com.ajaymourya.android.network.repositories.MovieRepository
import com.ajaymourya.android.network.services.MovieService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class
    ]
)
interface CoreComponent {

    fun context(): Context

    fun movieService(): MovieService

    fun movieRepository(): MovieRepository
}
