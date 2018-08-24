package com.example.nhoelle.coroutines.api

import android.util.Base64
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.normanhoeller.githubmbition.api.ShutterStockService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Service {

    private var client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(getAuthString()))
            .build()

    val service: ShutterStockService = Retrofit.Builder()
            .baseUrl("https://api.shutterstock.com/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ShutterStockService::class.java)

    private fun getAuthString(): String {
        val authInfo = "944caf99dfc4aa6186b0:d459648217e840dc9ffc77aea5a001cd4a972e4b"
        return "Basic " + Base64.encodeToString(authInfo.toByteArray(), Base64.NO_WRAP)

    }
}