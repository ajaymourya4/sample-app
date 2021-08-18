package com.ajaymourya.android.network.responses

import com.google.gson.annotations.SerializedName

data class PageResponse<T>(
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    val results: List<T>
)
