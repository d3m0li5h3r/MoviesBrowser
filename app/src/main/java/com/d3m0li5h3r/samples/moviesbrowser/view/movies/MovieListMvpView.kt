package com.d3m0li5h3r.samples.moviesbrowser.view.movies

import com.d3m0li5h3r.samples.moviesbrowser.models.Movie
import com.d3m0li5h3r.samples.moviesbrowser.view.MvpView

interface MovieListMvpView : MvpView {
    fun setMovies(movies: List<Movie>)
    fun addMovies(movies: List<Movie>)

    fun showProgressIndicator()

    fun showMessage(stringId: Int)

    fun showLoadMore()
    fun hideLoadMore()
}