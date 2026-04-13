package com.kingslayer06.anime_app.di

import com.kingslayer06.core.network.di.getNetworkModule
import com.kingslayer06.home.data.di.getHomeDataModule
import com.kingslayer06.home.di.getHomePresentationModule
import com.kingslayer06.home.domain.di.getHomeDomainModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            getNetworkModule(),
            
            getHomeDataModule(),
            getHomeDomainModule(),
            getHomePresentationModule()
        )
    }
}