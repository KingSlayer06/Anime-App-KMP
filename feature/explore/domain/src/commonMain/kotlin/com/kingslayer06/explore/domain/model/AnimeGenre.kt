package com.kingslayer06.explore.domain.model

data class AnimeGenre(
    val id: Int,
    val name: String
) {
    companion object {
        val dummyList = listOf(
            AnimeGenre(1, "Action"),
            AnimeGenre(2, "Adventure"),
            AnimeGenre(3, "Comedy"),
            AnimeGenre(4, "Drama"),
            AnimeGenre(5, "Fantasy")
        )
    }
}