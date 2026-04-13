package com.kingslayer06.home.domain.useCases

import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class GetTopAnimeUseCase(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(): Result<List<Anime>> = homeRepository.getTopAnime()
}