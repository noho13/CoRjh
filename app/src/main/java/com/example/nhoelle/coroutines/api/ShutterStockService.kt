package com.normanhoeller.githubmbition.api

import com.example.nhoelle.coroutines.model.SearchResult
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface ShutterStockService {

    @GET("/images/search?per_page=30")
    fun getSearchResult(@Query("query") query: String): Deferred<SearchResult>
}