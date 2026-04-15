package com.kingslayer06.home.data.repository

import com.kingslayer06.core.network.model.AnimeDto
import com.kingslayer06.core.network.service.AnimeService
import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.core.network.util.map
import com.kingslayer06.core.network.util.retryOnFailure
import com.kingslayer06.core.util.toFormattedString
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val service: AnimeService
): HomeRepository {
    override suspend fun getTopRatedAnime(limit: Int, filter: String): Response<List<Anime>, DataError> {
        return retryOnFailure {
            service.getTopRatedAnime(limit, filter)
                .map { responseDto ->
                    responseDto.data.map { it.toDomain() }
                }
        }
    }

    override suspend fun getThisSeasonAnime(limit: Int): Response<List<Anime>, DataError> {
        return retryOnFailure {
            service.getThisSeasonAnime(limit)
                .map { responseDto ->
                    responseDto.data.map { it.toDomain() }
                }
        }
    }

    override suspend fun getUpcomingSeasonAnime(limit: Int): Response<List<Anime>, DataError> {
        return retryOnFailure {
            service.getUpcomingSeasonAnime(limit)
                .map { responseDto ->
                    responseDto.data.map { it.toDomain() }
                }
        }
    }
}

private fun AnimeDto.toDomain(): Anime {
    return Anime(
        uuid = malId,
        title = titleEnglish ?: title,
        image = images?.jpg?.imageUrl,
        favourites = favorites.toFormattedString()
    )
}