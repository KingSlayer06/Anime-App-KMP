package com.kingslayer06.home.domain.useCases

import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.repository.HomeRepository

class GetTopRatedAnimeUseCase(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(limit: Int, filter: String): Response<List<Anime>, DataError> = homeRepository.getTopRatedAnime(limit, filter)
}