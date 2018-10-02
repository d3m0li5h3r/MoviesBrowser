package com.d3m0li5h3r.samples.moviesbrowser.view.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d3m0li5h3r.samples.moviesbrowser.R
import com.d3m0li5h3r.samples.moviesbrowser.models.Movie
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {
    private val movies = ArrayList<Movie>()

    fun setMovies(movieList: List<Movie>) {
        movies.clear()

        movies.addAll(movieList)

        notifyDataSetChanged()
    }

    fun addMovies(movieList: List<Movie>) {
        val startIndex = movies.size

        movies.addAll(movieList)

        notifyItemRangeInserted(startIndex, movieList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_movie, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.movie = movie

        holder.titleView.text = movie.title
    }

    override fun getItemCount() = movies.size

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView = view
        val titleView = view.title
        lateinit var movie: Movie
    }

}