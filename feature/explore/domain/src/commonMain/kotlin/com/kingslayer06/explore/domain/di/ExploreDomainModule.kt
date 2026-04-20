package com.kingslayer06.explore.domain.di

import com.kingslayer06.explore.domain.useCases.GetAnimeGenreUseCase
import com.kingslayer06.explore.domain.useCases.SearchAnimeUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getExploreDomainModule(): Module {
    return module {
        factory { GetAnimeGenreUseCase(get()) }
        factory { SearchAnimeUseCase(get()) }
    }
}