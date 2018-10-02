package com.d3m0li5h3r.samples.moviesbrowser.movies

import android.content.Context
import com.d3m0li5h3r.samples.moviesbrowser.MoviesBrowserApplication
import com.d3m0li5h3r.samples.moviesbrowser.api.ApiService
import com.d3m0li5h3r.samples.moviesbrowser.presenter.movies.MovieListPresenter
import com.d3m0li5h3r.samples.moviesbrowser.view.movies.MovieListMvpView
import com.getTestContext
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieListPresenterTest {
    private lateinit var application: MoviesBrowserApplication
    private lateinit var context: Context
    private lateinit var apiService: ApiService
    private lateinit var mvpView: MovieListMvpView
    private lateinit var presenter: MovieListPresenter

    @Before
    fun setup() {
        context = getTestContext()
        application = MoviesBrowserApplication[context]

        apiService = mock(ApiService::class.java)
        application.apiService = apiService

        mvpView = mock(MovieListMvpView::class.java)
        `when`(mvpView.ctx).thenReturn(context)

        presenter = MovieListPresenter()
        presenter.attachView(mvpView)
    }

    @Test
    fun shouldShowMovieList_onLoadMovies() {
    }

}