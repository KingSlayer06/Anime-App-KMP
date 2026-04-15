package com.kingslayer06.home.di

import com.kingslayer06.home.presentation.HomeViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val viewModelModule = module {
    factory {
        HomeViewModel(
            getTopRatedAnimeUseCase = get(),
            getThisSeasonAnimeUseCase = get(),
            getUpcomingSeasonAnimeUseCase = get()
        )
    }
}

actual fun getHomePresentationModule(): Module {
    return viewModelModule
}

class HomeViewModelProvider: KoinComponent {
    fun provideHomeViewModel(): HomeViewModel = get()
}