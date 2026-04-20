package com.kingslayer06.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AnimeGenreResponseDto(
    val data: List<AnimeGenreDto>
)