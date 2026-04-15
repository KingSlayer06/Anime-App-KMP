package com.kingslayer06.core.network.model

import com.kingslayer06.core.network.model.shared.GenreDto
import com.kingslayer06.core.network.model.shared.ImagesDto
import com.kingslayer06.core.network.model.shared.ProducerDto
import com.kingslayer06.core.network.model.shared.StudioDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeDto(
    @SerialName("mal_id")
    val malId: Int,
    @SerialName("title_english")
    val titleEnglish: String?,
    val title: String,
    val images: ImagesDto? = null,
    val type: String? = null,
    val episodes: Int? = null,
    val status: String? = null,
    val score: Double? = null,
    val rank: Int? = null,
    val favorites: Int,
    val synopsis: String? = null,
    val season: String? = null,
    val year: Int? = null,
    val genres: List<GenreDto>? = null,
    val studios: List<StudioDto>? = null,
    val producers: List<ProducerDto>? = null,
)