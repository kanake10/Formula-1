package com.example.formula1.util

import okhttp3.Interceptor
import okhttp3.Response

/**
 * this interceptor isn't used,,,headers passed already
 */
class ConstructorInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-RapidAPI-Key", "")
            .addHeader("X-RapidAPI-Host", "")
            .build()
        return chain.proceed(request)
    }
}