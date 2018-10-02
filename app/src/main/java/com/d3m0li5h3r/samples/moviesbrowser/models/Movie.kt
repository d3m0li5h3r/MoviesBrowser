package com.d3m0li5h3r.samples.moviesbrowser.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(
        @Expose @SerializedName(value = "vote_count") val votes: Long,
        @Expose @SerializedName(value = "id") val id: Long,
        @Expose @SerializedName(value = "vote_average") val rating: Double,
        @Expose @SerializedName(value = "title") val title: String,
        @Expose @SerializedName(value = "poster_path") val poster: String,
        @Expose @SerializedName(value = "overview") val overview: String,
        @Expose @SerializedName(value = "release_date") val releaseDate: String,
        @Expose @SerializedName(value = "runtime") val runtimeInSeconds: Int,
        @Expose @SerializedName(value = "homepage") val homepage: String
)