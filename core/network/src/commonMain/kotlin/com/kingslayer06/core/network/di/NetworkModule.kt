package com.kingslayer06.core.network.di

import com.kingslayer06.core.network.client.HttpClientFactory
import com.kingslayer06.core.network.service.AnimeService
import com.kingslayer06.core.network.service.AnimeServiceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

fun getNetworkModule(): Module {
    return module {
        single<AnimeService> { AnimeServiceImpl(HttpClientFactory.getInstance()) }
    }
}