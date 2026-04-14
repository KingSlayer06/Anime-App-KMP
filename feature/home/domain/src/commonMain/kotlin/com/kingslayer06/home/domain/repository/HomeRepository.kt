package com.kingslayer06.home.domain.repository

import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.home.domain.model.Anime

interface HomeRepository {
    suspend fun getTopRatedAnime(limit: Int, filter: String): Response<List<Anime>, DataError>
    suspend fun getThisSeasonAnime(limit: Int): Response<List<Anime>, DataError>
    suspend fun getUpcomingSeasonAnime(limit: Int): Response<List<Anime>, DataError>
}