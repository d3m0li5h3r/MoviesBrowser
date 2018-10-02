package com.d3m0li5h3r.samples.moviesbrowser.presenter.movies

import com.d3m0li5h3r.samples.moviesbrowser.MoviesBrowserApplication
import com.d3m0li5h3r.samples.moviesbrowser.R
import com.d3m0li5h3r.samples.moviesbrowser.api.models.DiscoverMovieResponse
import com.d3m0li5h3r.samples.moviesbrowser.presenter.Presenter
import com.d3m0li5h3r.samples.moviesbrowser.util.logError
import com.d3m0li5h3r.samples.moviesbrowser.view.movies.MovieListMvpView
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MovieListPresenter : Presenter<MovieListMvpView> {
    private val defaultPage = 1

    private lateinit var application: MoviesBrowserApplication

    private var mvpView: MovieListMvpView? = null

    private var currentPage = defaultPage
    private var totalPages = defaultPage

    override fun attachView(view: MovieListMvpView) {
        mvpView = view

        application = MoviesBrowserApplication[view.ctx]
    }

    override fun detachView() {
        mvpView = null
    }

    fun loadMovies() {
        currentPage = defaultPage

        getMovies()
    }

    fun loadMoreMovies() {
        ++currentPage

        getMovies()
    }

    private fun getMovies() {
        showProgressIndicator()

        val apiService = application.apiService!!

        apiService.getMovies(currentPage)
                .subscribeOn(application.ioScheduler)
                .observeOn(application.mainScheduler)
                .subscribe(object : SingleObserver<DiscoverMovieResponse> {
                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onSuccess(response: DiscoverMovieResponse) {
                        handleResponse(response)
                    }

                    override fun onError(error: Throwable) {
                        handleError(error)
                    }
                })
    }

    private fun showProgressIndicator() {
        if (defaultPage == currentPage) {
            mvpView?.showProgressIndicator()
        } else {
            mvpView?.showLoadMore()
        }
    }

    private fun handleResponse(response: DiscoverMovieResponse) {
        totalPages = response.totalPages

        if (response.movies.isEmpty()) {
            showErrorOrHideLoadMore(R.string.error_message_no_movies)
        } else {
            if (defaultPage == currentPage) {
                mvpView?.setMovies(response.movies)
            } else {
                mvpView?.addMovies(response.movies)
            }
        }
    }

    private fun handleError(error: Throwable) {
        logError(error)

        showErrorOrHideLoadMore(R.string.error_message_something_went_wrong)
    }

    private fun showErrorOrHideLoadMore(stringId: Int) {
        if (defaultPage == currentPage) {
            mvpView?.showMessage(stringId)
        } else {
            mvpView?.hideLoadMore()
        }
    }

    fun handleScroll() {

    }
}