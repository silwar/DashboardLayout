package com.silwar.dashboard.model

import com.google.gson.annotations.SerializedName

data class DashboardItemResponse(
    @SerializedName("id")
    val identifier: Int,
    @SerializedName("order")
    val order: Int,
    @SerializedName("style")
    val style: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("content_type")
    val contentType: String,
    @SerializedName("content")
    val content: ContentResponse
)