package com.kingslayer06.home.domain.di

import com.kingslayer06.home.domain.useCases.GetTopAnimeUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getHomeDomainModule(): Module {
    return module {
        factory { GetTopAnimeUseCase(get()) }
    }
}