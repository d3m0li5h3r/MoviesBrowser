package com.d3m0li5h3r.samples.moviesbrowser

import android.app.Application
import android.content.Context
import com.d3m0li5h3r.samples.moviesbrowser.api.ApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class MoviesBrowserApplication : Application() {
    companion object {
        operator fun get(context: Context): MoviesBrowserApplication =
                context.applicationContext as MoviesBrowserApplication
    }

    var apiService: ApiService? = null
        get() {
            if (null == field) {
                field = ApiService.Factory.create()
            }

            return field
        }

    var ioScheduler: Scheduler? = null
        get() {
            if (null == field) {
                field = Schedulers.io()
            }

            return field
        }

    var mainScheduler: Scheduler? = null
        get() {
            if (null == field) {
                field = AndroidSchedulers.mainThread()
            }

            return field
        }
}