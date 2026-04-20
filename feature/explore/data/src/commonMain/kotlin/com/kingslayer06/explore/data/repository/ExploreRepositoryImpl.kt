package com.kingslayer06.explore.data.repository

import com.kingslayer06.core.network.model.AnimeDto
import com.kingslayer06.core.network.model.AnimeGenreDto
import com.kingslayer06.core.network.service.AnimeService
import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.core.network.util.map
import com.kingslayer06.core.network.util.retryOnFailure
import com.kingslayer06.core.util.toFormattedString
import com.kingslayer06.explore.domain.model.Anime
import com.kingslayer06.explore.domain.model.AnimeGenre
import com.kingslayer06.explore.domain.repository.ExploreRepository

class ExploreRepositoryImpl(
    private val animeService: AnimeService
): ExploreRepository {
    override suspend fun getAnimeGenre(): Response<List<AnimeGenre>, DataError> {
        return retryOnFailure {
            animeService.getAnimeGenres()
                .map { responseDto ->
                    responseDto.data.map { it.toDomain() }
                }
        }
    }

    override suspend fun searchAnime(limit: Int, query: String): Response<List<Anime>, DataError> {
        return retryOnFailure {
            animeService.searchAnime(limit, query)
                .map { responseDto ->
                    responseDto.data.map { it.toDomain() }
                }
        }
    }
}

fun AnimeGenreDto.toDomain(): AnimeGenre {
    return AnimeGenre(
        id = malId,
        name = name
    )
}

fun AnimeDto.toDomain(): Anime {
    return Anime(
        uuid = malId,
        title = titleEnglish ?: title,
        image = images?.jpg?.imageUrl,
        favourites = favorites.toFormattedString()
    )
}