package com.kingslayer06.details.domain.di

import com.kingslayer06.details.domain.repository.DetailsRepository
import com.kingslayer06.details.domain.repository.DetailsRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDetailsDataModule(): Module {
    return module {
        single<DetailsRepository> { DetailsRepositoryImpl(get()) }
    }
}