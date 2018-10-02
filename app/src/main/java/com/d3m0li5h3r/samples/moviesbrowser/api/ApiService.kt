package com.d3m0li5h3r.samples.moviesbrowser.api

import com.d3m0li5h3r.samples.moviesbrowser.api.models.DiscoverMovieResponse
import com.d3m0li5h3r.samples.moviesbrowser.models.Movie
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET(value = ENDPOINT_DISCOVER_MOVIES)
    fun getMovies(@Query(value = "page") pageNumber: Long): Observable<DiscoverMovieResponse>

    @GET(value = ENDPOINT_MOVIE_DETAILS)
    fun getMovieDetails(@Path(value = "movie_id") movieId: Long): Observable<Movie>

    class Factory {
        companion object {
            fun create(): ApiService {
                val gson = GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create()

                val okHttpClientBuilder = OkHttpClient.Builder()
                        .readTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
                        .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                        .addInterceptor(RequestInterceptor())

                val retrofit = Retrofit.Builder()
                        .baseUrl(URL_BASE)
                        .client(okHttpClientBuilder.build())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()

                return retrofit.create(ApiService::class.java)
            }
        }
    }
}