package com.kingslayer06.details.domain.useCases

import com.kingslayer06.details.domain.repository.DetailsRepository

class GetAnimeByIdUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend fun execute(id: Int) = detailsRepository.getAnimeById(id)
}