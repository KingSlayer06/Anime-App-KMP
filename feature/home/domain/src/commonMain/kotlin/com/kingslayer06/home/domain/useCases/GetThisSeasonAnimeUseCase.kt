package com.kingslayer06.home.domain.useCases

import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class GetThisSeasonAnimeUseCase(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(limit: Int): Response<List<Anime>, DataError> = homeRepository.getThisSeasonAnime(limit)
}