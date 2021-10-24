package com.ajaymourya.android.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ajaymourya.android.network.repositories.MovieRepository
import com.ajaymourya.android.ui.list.model.MovieItem
import com.ajaymourya.android.ui.list.model.toMovieItemList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieListViewModel(val movieRepository: MovieRepository) : ViewModel() {

    private val _movieList = MutableStateFlow<List<MovieItem>>(emptyList())
    val movieList: StateFlow<List<MovieItem>> = _movieList

    init {
        getTrendingMovies()
    }

    fun getTrendingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = movieRepository.getTrendingMovies()
            _movieList.value = result.toMovieItemList()
        }
    }

    fun getPaginatedTrendingMovies(): Flow<PagingData<MovieItem>> {
        return movieRepository.getPaginatedTrendingMovies()
            .cachedIn(viewModelScope)
    }
}
