package com.d3m0li5h3r.samples.moviesbrowser.api.models

import com.d3m0li5h3r.samples.moviesbrowser.models.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DiscoverMovieResponse(
        @Expose @SerializedName(value = "page") val currentPage: Int,
        @Expose @SerializedName(value = "total_results") val totalResults: Long,
        @Expose @SerializedName(value = "total_pages") val totalPages: Int,
        @Expose @SerializedName(value = "results") val movies: List<Movie>
)