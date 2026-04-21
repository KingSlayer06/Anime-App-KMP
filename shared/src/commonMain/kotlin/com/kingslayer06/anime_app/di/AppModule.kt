package com.kingslayer06.anime_app.di

import com.kingslayer06.core.network.di.getNetworkModule
import com.kingslayer06.details.domain.di.getDetailsDataModule
import com.kingslayer06.details.domain.di.getDetailsDomainModule
import com.kingslayer06.details.presentation.di.getDetailsPresentationModule
import com.kingslayer06.explore.data.di.getExploreDataModule
import com.kingslayer06.explore.domain.di.getExploreDomainModule
import com.kingslayer06.explore.presentation.di.getExplorePresentationModule
import com.kingslayer06.home.data.di.getHomeDataModule
import com.kingslayer06.home.presentation.di.getHomePresentationModule
import com.kingslayer06.home.domain.di.getHomeDomainModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            getNetworkModule(),

            getHomeDataModule(),
            getHomeDomainModule(),
            getHomePresentationModule(),

            getExploreDataModule(),
            getExploreDomainModule(),
            getExplorePresentationModule(),

            getDetailsDataModule(),
            getDetailsDomainModule(),
            getDetailsPresentationModule()
        )
    }
}