package com.bandeev.tz.app

import android.app.Application
import com.bandeev.all_courses.di.allCoursesModule
import com.bandeev.core.course.di.courseModule
import com.bandeev.data.di.dataModule
import com.bandeev.domain.di.domainModule
import com.bandeev.feature.auth.di.authModule
import com.bandeev.tz.di.mainModule
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
            modules(authModule + allCoursesModule + dataModule + domainModule + mainModule+ courseModule)
        }
    }
}