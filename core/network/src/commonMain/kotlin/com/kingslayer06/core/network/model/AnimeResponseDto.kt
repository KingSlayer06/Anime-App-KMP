package com.kingslayer06.core.network.model

import com.kingslayer06.core.network.model.shared.PaginationDto
import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponseDto(
    val pagination: PaginationDto? = null,
    val data: List<AnimeDto> = emptyList()
)