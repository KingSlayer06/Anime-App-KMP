package com.kingslayer06.home.domain.useCases

import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class GetThisSeasonAnimeUseCase(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(limit: Int): Result<List<Anime>> = homeRepository.getThisSeasonAnime(limit)
}