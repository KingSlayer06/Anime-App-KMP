package com.kingslayer06.core.network.model.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StudioDto(
    @SerialName("mal_id") val malId: Int,
    @SerialName("type") val type: String?,
    @SerialName("name") val name: String,
    @SerialName("url") val url: String?
)