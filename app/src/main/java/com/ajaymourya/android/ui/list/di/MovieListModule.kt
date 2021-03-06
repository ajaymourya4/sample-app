package com.ajaymourya.android.ui.list.di

import androidx.fragment.app.viewModels
import com.ajaymourya.android.network.repositories.MovieRepository
import com.ajaymourya.android.ui.list.MovieListFragment
import com.ajaymourya.android.ui.list.MovieListViewModel
import com.ajaymourya.android.ui.list.MovieListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieListModule(val fragment: MovieListFragment) {

    @Provides
    fun providesMovieListViewModel(movieRepository: MovieRepository): MovieListViewModel = fragment.viewModels<MovieListViewModel> { MovieListViewModelFactory(movieRepository) }.value
}
