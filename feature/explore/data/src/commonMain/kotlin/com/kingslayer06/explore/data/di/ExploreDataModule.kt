package com.kingslayer06.explore.data.di

import com.kingslayer06.explore.domain.repository.ExploreRepository
import org.koin.core.module.Module
import org.koin.dsl.module
import com.kingslayer06.explore.data.repository.ExploreRepositoryImpl

fun getExploreDataModule(): Module {
    return module {
        single<ExploreRepository> { ExploreRepositoryImpl(get()) }
    }
}