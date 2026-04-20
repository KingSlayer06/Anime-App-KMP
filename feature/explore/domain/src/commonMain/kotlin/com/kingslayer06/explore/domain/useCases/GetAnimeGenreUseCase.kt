package com.kingslayer06.explore.domain.useCases

import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.explore.domain.model.AnimeGenre
import com.kingslayer06.explore.domain.repository.ExploreRepository

class GetAnimeGenreUseCase(
    private val exploreRepository: ExploreRepository
) {
    suspend fun execute(): Response<List<AnimeGenre>, DataError> = exploreRepository.getAnimeGenre()
}