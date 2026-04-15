package com.kingslayer06.details.domain.di

import com.kingslayer06.details.domain.useCases.GetAnimeByIdUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDetailsDomainModule(): Module {
    return module {
        factory { GetAnimeByIdUseCase(get()) }
    }
}