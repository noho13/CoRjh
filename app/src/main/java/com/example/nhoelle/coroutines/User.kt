package com.example.nhoelle.coroutines

import com.google.gson.annotations.SerializedName

data class User(
        val login: String,
        val id: Int,
        val url: String,
        @SerializedName("avatar_url") val avatar: String
)