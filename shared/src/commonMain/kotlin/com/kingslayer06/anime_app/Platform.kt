package com.kingslayer06.anime_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform