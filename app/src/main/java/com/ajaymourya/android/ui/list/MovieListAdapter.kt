package com.ajaymourya.android.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajaymourya.android.databinding.LayoutMovieListItemBinding
import com.ajaymourya.android.ui.list.model.MovieItem

class MovieListAdapter(private var dataSet: List<MovieItem>) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder = MovieListViewHolder.create(parent)

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) = holder.bind(dataSet[position])

    override fun getItemCount(): Int = dataSet.size

    fun submitList(dataSet: List<MovieItem>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
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
}
