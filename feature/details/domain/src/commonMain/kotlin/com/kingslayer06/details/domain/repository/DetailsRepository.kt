package com.kingslayer06.details.domain.repository

import com.kingslayer06.core.network.util.DataError
import com.kingslayer06.core.network.util.Response
import com.kingslayer06.details.domain.model.Anime

interface DetailsRepository {
    suspend fun getAnimeById(id: Int): Response<Anime, DataError>
}