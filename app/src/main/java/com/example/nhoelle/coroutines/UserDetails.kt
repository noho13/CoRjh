package com.example.nhoelle.coroutines

import com.google.gson.annotations.SerializedName

data class UserDetails(
        val name: String?,
        val location: String?,
        @SerializedName("avatar_url") val icon: String,
        @SerializedName("public_repos") val publicRepos: Int,
        @SerializedName("public_gists") val publicGists: Int,
        val followers: Int,
        val following: Int

)