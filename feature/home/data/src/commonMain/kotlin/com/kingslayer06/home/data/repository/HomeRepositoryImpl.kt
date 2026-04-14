package com.kingslayer06.home.data.repository

import com.kingslayer06.core.network.model.AnimeDto
import com.kingslayer06.core.network.service.AnimeService
import com.kingslayer06.core.util.toFormattedString
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val service: AnimeService
): HomeRepository {
    override suspend fun getTopRatedAnime(limit: Int, filter: String): Result<List<Anime>> {
        val result = service.getTopRatedAnime(limit, filter)
        return result.map { response ->
            response.data.map { map(it) }
        }
    }

    override suspend fun getThisSeasonAnime(limit: Int): Result<List<Anime>> {
        val result = service.getThisSeasonAnime(limit)
        return result.map { response ->
            response.data.map { map(it) }
        }
    }

    override suspend fun getUpcomingSeasonAnime(limit: Int): Result<List<Anime>> {
        val result = service.getUpcomingSeasonAnime(limit)
        return result.map { response ->
            response.data.map { map(it) }
        }
    }
}

private fun map(dto: AnimeDto): Anime {
    return Anime(
        uuid = dto.malId.toString(),
        title = dto.titleEnglish ?: dto.title,
        image = dto.images?.jpg?.imageUrl,
        favourites = dto.favorites.toFormattedString()
    )
}