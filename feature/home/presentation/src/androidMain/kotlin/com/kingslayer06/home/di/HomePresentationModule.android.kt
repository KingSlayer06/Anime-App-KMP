package com.kingslayer06.home.di

import com.kingslayer06.home.presentation.HomeViewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

actual fun getHomePresentationModule(): Module {
    return module {
        viewModel {
            HomeViewModel(
                getTopRatedAnimeUseCase = get(),
                getThisSeasonAnimeUseCase = get(),
                getUpcomingSeasonAnimeUseCase = get()
            )
        }
    }
}