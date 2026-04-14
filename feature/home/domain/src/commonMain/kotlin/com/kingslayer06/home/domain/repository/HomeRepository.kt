package com.kingslayer06.home.domain.repository

import com.kingslayer06.home.domain.model.Anime

interface HomeRepository {
    suspend fun getTopRatedAnime(limit: Int, filter: String): Result<List<Anime>>
    suspend fun getThisSeasonAnime(limit: Int): Result<List<Anime>>
    suspend fun getUpcomingSeasonAnime(limit: Int): Result<List<Anime>>
}