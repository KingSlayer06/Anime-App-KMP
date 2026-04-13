package com.kingslayer06.home.data.di

import com.kingslayer06.home.data.repository.HomeRepositoryImpl
import com.kingslayer06.home.domain.repository.HomeRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getHomeDataModule(): Module {
    return module {
        single<HomeRepository> { HomeRepositoryImpl(get()) }
    }
}