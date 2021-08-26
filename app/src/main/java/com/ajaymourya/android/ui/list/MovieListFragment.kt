package com.ajaymourya.android.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ajaymourya.android.R
import com.ajaymourya.android.SampleApp.Companion.coreComponent
import com.ajaymourya.android.ui.list.di.DaggerMovieListComponent
import com.ajaymourya.android.ui.list.di.MovieListModule
import javax.inject.Inject

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    @Inject
    lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initDependencyInjection()
    }

    private fun initDependencyInjection() {
        DaggerMovieListComponent
            .builder()
            .coreComponent(coreComponent(requireContext()))
            .movieListModule(MovieListModule(this))
            .build()
            .inject(this)
    }
}
