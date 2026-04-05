package com.bandeev.feature.auth.app

import android.app.Application
import com.bandeev.feature.auth.di.dataModule
import com.bandeev.feature.auth.di.domainModule
import com.bandeev.feature.auth.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}