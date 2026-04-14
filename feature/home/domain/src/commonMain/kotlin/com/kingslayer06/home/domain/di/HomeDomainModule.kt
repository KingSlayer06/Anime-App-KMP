package com.kingslayer06.home.domain.di

import com.kingslayer06.home.domain.useCases.GetThisSeasonAnimeUseCase
import com.kingslayer06.home.domain.useCases.GetTopRatedAnimeUseCase
import com.kingslayer06.home.domain.useCases.GetUpcomingSeasonAnimeUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getHomeDomainModule(): Module {
    return module {
        factory { GetTopRatedAnimeUseCase(get()) }
        factory { GetThisSeasonAnimeUseCase(get()) }
        factory { GetUpcomingSeasonAnimeUseCase(get()) }
    }
}