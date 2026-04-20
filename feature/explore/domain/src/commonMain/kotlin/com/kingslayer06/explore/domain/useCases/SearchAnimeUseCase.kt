package com.kingslayer06.explore.domain.useCases

import com.kingslayer06.explore.domain.repository.ExploreRepository

class SearchAnimeUseCase(
    val exploreRepository: ExploreRepository
) {
    suspend fun execute(limit: Int, query: String) = exploreRepository.searchAnime(limit, query)
}