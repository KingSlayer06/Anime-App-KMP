package com.kingslayer06.core.network.model.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrailerDto(
    @SerialName("youtube_id") val youtubeId: String?,
    @SerialName("embed_url") val embedUrl: String?
)