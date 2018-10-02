package com.d3m0li5h3r.samples.moviesbrowser.api

const val TIMEOUT_REQUEST = 60L
const val TIMEOUT_CONNECTION = 60L

const val URL_BASE = "https://api.themoviedb.org/3/"

const val ENDPOINT_DISCOVER_MOVIES = "discover/movie"
const val ENDPOINT_MOVIE_DETAILS = "movie/{movie_id}"

const val PARAM_API_KEY = "api_key"

//Api key hardcoded here is just for demo purposes. It should not hardcoded in actual apps.
const val DEFAULT_API_KEY = "<api key>"
