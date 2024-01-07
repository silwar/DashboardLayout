package com.silwar.dashboard.model

import com.google.gson.annotations.SerializedName

data class ContentResponse(
    @SerializedName("image_identifier")
    val imageId: String?,
    @SerializedName("label")
    val label: LabelResponse?
)

data class LabelResponse(
    @SerializedName("text")
    val text: String
)