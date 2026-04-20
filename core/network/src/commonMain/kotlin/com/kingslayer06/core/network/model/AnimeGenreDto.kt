package com.kingslayer06.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeGenreDto(
    @SerialName("mal_id")
    val malId: Int,
    val name: String
)