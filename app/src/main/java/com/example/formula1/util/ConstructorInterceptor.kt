package com.example.formula1.util

import okhttp3.Interceptor
import okhttp3.Response

class ConstructorInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-RapidAPI-Key", "7b5273655emsh4047f04c6f9eaa7p1924a3jsnce0de28823dc")
            .addHeader("X-RapidAPI-Host", "formula-1-standings.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}