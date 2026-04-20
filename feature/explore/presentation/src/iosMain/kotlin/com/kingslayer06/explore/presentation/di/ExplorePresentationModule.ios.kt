package com.kingslayer06.explore.presentation.di

import com.kingslayer06.explore.presentation.ExploreViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val viewModelModule = module {
    single {
        ExploreViewModel(
            getAnimeGenreUseCase = get(),
            searchAnimeUseCase = get()
        )
    }
}

actual fun getExplorePresentationModule(): Module {
    return viewModelModule
}

class ExploreViewModelProvider: KoinComponent {
    fun provideExploreViewModel(): ExploreViewModel = get()
}