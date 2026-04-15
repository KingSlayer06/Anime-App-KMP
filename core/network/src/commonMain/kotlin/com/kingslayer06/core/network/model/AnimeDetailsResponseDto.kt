package com.kingslayer06.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AnimeDetailsResponseDto(
    val data: AnimeDto
)