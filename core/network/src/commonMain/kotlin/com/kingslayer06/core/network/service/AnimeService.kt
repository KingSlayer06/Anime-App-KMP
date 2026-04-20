package com.kingslayer06.core.network.service

import com.kingslayer06.core.network.model.AnimeDetailsResponseDto
import com.kingslayer06.core.network.model.AnimeGenreResponseDto
import com.kingslayer06.core.network.model.AnimeResponseDto
import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.core.network.util.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface AnimeService {
    suspend fun getTopRatedAnime(limit: Int, filter: String): Response<AnimeResponseDto, DataError>
    suspend fun getThisSeasonAnime(limit: Int): Response<AnimeResponseDto, DataError>
    suspend fun getUpcomingSeasonAnime(limit: Int): Response<AnimeResponseDto, DataError>
    suspend fun getAnimeById(id: Int): Response<AnimeDetailsResponseDto, DataError>
    suspend fun searchAnime(limit: Int, query: String): Response<AnimeResponseDto, DataError>
    suspend fun getAnimeGenres(): Response<AnimeGenreResponseDto, DataError>
}

class AnimeServiceImpl(
    private val httpClient: HttpClient
): AnimeService {
    private suspend inline fun <reified T> getRequest(endpoint: String): Response<T, DataError> {
        val result = safeCall<T> {
            httpClient.get(endpoint)
        }

        return when(result) {
            is Response.Success -> Response.Success(result.data)
            is Response.Error -> Response.Error(result.error)
        }
    }

    override suspend fun getTopRatedAnime(limit: Int, filter: String): Response<AnimeResponseDto, DataError> = getRequest("/top/anime?filter=$filter&limit=$limit")
    override suspend fun getThisSeasonAnime(limit: Int): Response<AnimeResponseDto, DataError> = getRequest("/seasons/now?limit=$limit")
    override suspend fun getUpcomingSeasonAnime(limit: Int): Response<AnimeResponseDto, DataError> = getRequest("/seasons/upcoming?limit=$limit")
    override suspend fun getAnimeById(id: Int): Response<AnimeDetailsResponseDto, DataError> = getRequest("/anime/$id")
    override suspend fun searchAnime(limit: Int, query: String): Response<AnimeResponseDto, DataError> = getRequest("/anime?q=$query&limit=$limit")
    override suspend fun getAnimeGenres(): Response<AnimeGenreResponseDto, DataError> = getRequest("/genres/anime?filter=genres")
}