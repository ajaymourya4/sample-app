package com.ajaymourya.android.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ajaymourya.android.databinding.LayoutMovieListItemBinding
import com.ajaymourya.android.ui.list.model.MovieItem

class MovieListAdapter :
    PagingDataAdapter<MovieItem, MovieListAdapter.MovieListViewHolder>(MOVIE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder = MovieListViewHolder.create(parent)

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class MovieListViewHolder(val binding: LayoutMovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieItem) {
            binding.title.text = movie.title
            binding.overview.text = movie.overview
        }

        companion object {
            fun create(parent: ViewGroup): MovieListViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = LayoutMovieListItemBinding.inflate(inflater, parent, false)
                return MovieListViewHolder(binding)
            }
        }
    }

    companion object {
        val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<MovieItem>() {
            override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
