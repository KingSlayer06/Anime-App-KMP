package com.kingslayer06.explore.domain.repository

import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.explore.domain.model.Anime
import com.kingslayer06.explore.domain.model.AnimeGenre

interface ExploreRepository {
    suspend fun getAnimeGenre(): Response<List<AnimeGenre>, DataError>
    suspend fun searchAnime(limit: Int, query: String): Response<List<Anime>, DataError>
}