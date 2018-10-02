package com.d3m0li5h3r.samples.moviesbrowser.api

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val httpUrl = originalRequest.url().newBuilder()
                .addQueryParameter(PARAM_API_KEY, DEFAULT_API_KEY)
                .build()

        val requestBuilder = originalRequest.newBuilder()
                .url(httpUrl)

        return chain.proceed(requestBuilder.build())
    }
}