package com.normanhoeller.githubmbition.api

import com.example.nhoelle.coroutines.User
import com.example.nhoelle.coroutines.UserDetails
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {

    @GET("users")
    fun getUsers(): Deferred<List<User>>

    @GET("users/{id}")
    fun getUserDetails(@Path("id") id: Int): Deferred<ApiResponse<UserDetails>>

}