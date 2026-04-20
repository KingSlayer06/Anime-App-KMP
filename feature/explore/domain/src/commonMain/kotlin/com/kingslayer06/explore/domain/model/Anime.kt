package com.kingslayer06.explore.domain.model

data class Anime(
    val uuid: Int,
    val title: String,
    val image: String?,
    val favourites: String
) {
    companion object {
        val dummyList = listOf(
            Anime(1, "Naruto Shippuden", null, "44k"),
            Anime(2, "One Piece", null, "55k"),
            Anime(3, "Attack on Titan", null, "35k"),
            Anime(4, "Jujutsu Kaisen", null, "12k"),
            Anime(5, "Demon Slayer", null, "1k")
        )
    }
}