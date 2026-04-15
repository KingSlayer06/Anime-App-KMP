package com.kingslayer06.details.presentation.di

import com.kingslayer06.details.presentation.DetailsViewModel
import org.koin.core.component.get
import org.koin.core.component.KoinComponent
import org.koin.dsl.module

private val viewModelModule = module {
    factory {
        DetailsViewModel(get())
    }
}

actual fun getDetailsPresentationModule(): org.koin.core.module.Module {
    return viewModelModule
}

class DetailsViewModelProvider: KoinComponent {
    fun provideDetailsViewModel(): DetailsViewModel = get()
}