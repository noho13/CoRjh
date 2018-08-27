package com.example.nhoelle.coroutines.api

import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(private val credString: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        chain?.let {
            val request = it.request()
            val authenticatedRequest = request.newBuilder()
                    .header("Authorization", credString).build()
            chain.proceed(authenticatedRequest)
        }
        throw IllegalStateException("could not create response")
    }

}