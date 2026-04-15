package com.kingslayer06.details.domain.repository

import com.kingslayer06.core.network.model.AnimeDto
import com.kingslayer06.core.network.service.AnimeService
import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.core.network.util.map
import com.kingslayer06.core.network.util.retryOnFailure
import com.kingslayer06.core.util.toFormattedString
import com.kingslayer06.details.domain.model.Anime

class DetailsRepositoryImpl(
    private val service: AnimeService
): DetailsRepository {
    override suspend fun getAnimeById(id: Int): Response<Anime, DataError> {
        return retryOnFailure {
            service.getAnimeById(id)
                .map { responseDto ->
                    responseDto.data.toDomain()
                }
        }
    }
}

private fun AnimeDto.toDomain(): Anime {
    return Anime(
        uuid = malId,
        title = titleEnglish ?: title,
        image = images?.jpg?.imageUrl,
        favourites = favorites.toFormattedString(),
        score = score ?: 0.0,
        rank = rank ?: 0,
        status = status ?: "",
        description = synopsis ?: "",
        episodes = episodes ?: 0,
        producers = producers?.map { it.name } ?: emptyList(),
        genres = genres?.map { it.name } ?: emptyList(),
        studios = studios?.map { it.name } ?: emptyList()
    )
}