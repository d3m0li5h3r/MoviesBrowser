package com

import android.content.Context
import com.d3m0li5h3r.samples.moviesbrowser.MoviesBrowserApplication
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.mockito.Mockito
import org.mockito.Mockito.`when`

fun getTestContext(): Context {
    val application = Mockito.mock(MoviesBrowserApplication::class.java)
    `when`(application.applicationContext).thenReturn(application)

    return application
}

fun getTestDefaultScheduler(): Scheduler {
    return Schedulers.trampoline()
}

fun getTestMainScheduler(): Scheduler {
    return Schedulers.trampoline()
}