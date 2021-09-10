package com.ajaymourya.android.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ajaymourya.android.network.repositories.MovieRepository

class MovieListViewModelFactory(val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            return MovieListViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
