package com.d3m0li5h3r.samples.moviesbrowser.presenter


interface Presenter<V> {
    fun attachView(view: V)
    fun detachView()
}