package com.kingslayer06.anime_app

import android.app.Application
import com.kingslayer06.anime_app.di.initKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}