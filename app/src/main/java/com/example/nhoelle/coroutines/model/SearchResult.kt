package com.example.nhoelle.coroutines.model

import com.google.gson.annotations.SerializedName

data class SearchResult(val page: Int,
                        @SerializedName("per_page") val perPage: Int,
                        @SerializedName("total_count") val totalCount: Int,
                        val data: List<Data>)

data class Data(val id: String, val assets: Assets, val description: String)
data class Assets(val preview: Preview)
data class Preview(val height: Int, val width: Int, val url: String)




