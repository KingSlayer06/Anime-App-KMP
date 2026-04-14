package com.kingslayer06.home.domain.useCases

import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class GetTopRatedAnimeUseCase(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(limit: Int, filter: String): Result<List<Anime>> = homeRepository.getTopRatedAnime(limit, filter)
}