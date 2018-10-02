package com.d3m0li5h3r.samples.moviesbrowser.util

import android.util.Log

private const val LOG_TAG = "Movies Browser"

fun logError(error: Throwable) {
    Log.e(LOG_TAG, error.message, error)
}