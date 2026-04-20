package com.kingslayer06.explore.presentation.di

import com.kingslayer06.explore.presentation.ExploreViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

actual fun getExplorePresentationModule(): Module {
    return module {
        viewModel { ExploreViewModel(get(), get()) }
    }
}