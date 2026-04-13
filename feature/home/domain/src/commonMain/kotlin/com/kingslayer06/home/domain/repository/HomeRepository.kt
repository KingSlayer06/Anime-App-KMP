package com.kingslayer06.home.domain.repository

import com.kingslayer06.home.domain.model.Anime

interface HomeRepository {
    suspend fun getTopAnime(): Result<List<Anime>>
}