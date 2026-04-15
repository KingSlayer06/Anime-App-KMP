package com.kingslayer06.details.presentation.di

import com.kingslayer06.details.presentation.DetailsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

actual fun getDetailsPresentationModule(): Module {
    return module {
        viewModel { DetailsViewModel(get()) }
    }
}