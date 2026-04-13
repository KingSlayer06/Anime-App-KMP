package com.kingslayer06.core.network.model.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreDto(
    @SerialName("mal_id") val malId: Int,
    @SerialName("name") val name: String,
)