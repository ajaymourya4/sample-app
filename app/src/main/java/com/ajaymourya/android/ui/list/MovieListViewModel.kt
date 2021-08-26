package com.ajaymourya.android.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel

class MovieListViewModel() : ViewModel() {

    init {
        Log.e("MovieListViewModel", " INIT")
    }

    fun get() {
        Log.e("MovieListViewModel", " get")
    }
}
