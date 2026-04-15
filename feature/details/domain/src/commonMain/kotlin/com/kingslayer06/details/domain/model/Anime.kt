package com.kingslayer06.details.domain.model

data class Anime(
    val uuid: Int,
    val title: String,
    val image: String?,
    val favourites: String,
    val score: Double,
    val rank: Int,
    val status: String,
    val episodes: Int,
    val description: String,
    val producers: List<String>,
    val genres: List<String>,
    val studios: List<String>
)
