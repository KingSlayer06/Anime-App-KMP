package com.kingslayer06.core.network.service

import com.kingslayer06.core.network.model.AnimeResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface AnimeService {
    suspend fun getTopRatedAnime(limit: Int, filter: String): Result<AnimeResponseDto>
    suspend fun getThisSeasonAnime(limit: Int): Result<AnimeResponseDto>
    suspend fun getUpcomingSeasonAnime(limit: Int): Result<AnimeResponseDto>
}

class AnimeServiceImpl(
    private val httpClient: HttpClient
): AnimeService {
    private suspend inline fun <reified T> getRequest(endpoint: String): Result<T> {
        return try {
            val response = httpClient.get(endpoint).body<T>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTopRatedAnime(limit: Int, filter: String): Result<AnimeResponseDto> = getRequest("/top/anime?filter=$filter&limit=$limit")
    override suspend fun getThisSeasonAnime(limit: Int): Result<AnimeResponseDto> = getRequest("/seasons/now?limit=$limit")
    override suspend fun getUpcomingSeasonAnime(limit: Int): Result<AnimeResponseDto> = getRequest("/seasons/upcoming?limit=$limit")
}