package com.example.nhoelle.coroutines.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.normanhoeller.githubmbition.api.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    val service: GithubService = Retrofit.Builder()
                    .baseUrl("https://ws.audioscrobbler.com/2.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(GithubService::class.java)
}