package com.kingslayer06.home.data.repository

import com.kingslayer06.core.network.service.AnimeService
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val service: AnimeService
): HomeRepository {
    override suspend fun getTopAnime(): Result<List<Anime>> {
        val result = service.getTopAnime()
        return result.map { response ->
            response.data.map { dto ->
                Anime(
                    uuid = dto.malId.toString(),
                    title = dto.title,
                    image = dto.images?.jpg?.imageUrl
                )
            }
        }
    }
}