package com.d3m0li5h3r.samples.moviesbrowser.view.movies

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.d3m0li5h3r.samples.moviesbrowser.R
import com.d3m0li5h3r.samples.moviesbrowser.models.Movie
import com.d3m0li5h3r.samples.moviesbrowser.presenter.movies.MovieListPresenter
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity(), MovieListMvpView {
    override val ctx: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_movie_list)

        setSupportActionBar(toolbar)

        setupMovieList()

        val presenter = MovieListPresenter()
        presenter.attachView(this)

        presenter.loadMovies()
    }

    private fun setupMovieList() {
        val linearLayoutManager = LinearLayoutManager(ctx)
        list.layoutManager = linearLayoutManager

        val adapter = MovieListAdapter()
        list.adapter = adapter

        //TODO: set scroll listener
    }

    override fun setMovies(movies: List<Movie>) {
        progress.visibility = View.GONE

        list.visibility = View.VISIBLE

        val adapter = list.adapter as MovieListAdapter
        adapter.setMovies(movies)
    }

    override fun addMovies(movies: List<Movie>) {
        progress.visibility = View.GONE

        list.visibility = View.VISIBLE

        val adapter = list.adapter as MovieListAdapter
        adapter.addMovies(movies)
    }

    override fun showMessage(stringId: Int) {
        progress.visibility = View.GONE
        list.visibility = View.GONE

        message.setText(stringId)
        message.visibility = View.VISIBLE
    }

    override fun showProgressIndicator() {
        list.visibility = View.GONE
        message.visibility = View.GONE

        progress.visibility = View.VISIBLE
    }

    override fun showLoadMore() {
    }

    override fun hideLoadMore() {
    }
}