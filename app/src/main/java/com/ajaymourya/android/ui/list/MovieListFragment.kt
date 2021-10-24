package com.ajaymourya.android.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ajaymourya.android.SampleApp.Companion.coreComponent
import com.ajaymourya.android.databinding.FragmentMovieListBinding
import com.ajaymourya.android.ui.list.di.DaggerMovieListComponent
import com.ajaymourya.android.ui.list.di.MovieListModule
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var adapter: MovieListAdapter

    @Inject
    lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieListAdapter()
        binding.movieList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getPaginatedTrendingMovies().collectLatest {
                    adapter.submitData(it)
                }
            }
        }
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
