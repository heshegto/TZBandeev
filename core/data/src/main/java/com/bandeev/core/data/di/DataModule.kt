package com.bandeev.core.data.di

import com.bandeev.core.data.network.CoursesFromNetImpl
import com.bandeev.core.data.storage.CourseLocalStorageImpl
import com.bandeev.core.domain.repository.CourseLocalStorage
import com.bandeev.core.domain.repository.CoursesFromNet
import org.koin.dsl.module

val dataModule = module {
    // Storage
    single<CourseLocalStorage> { CourseLocalStorageImpl(get()) }

    // Network
    single<CoursesFromNet> { CoursesFromNetImpl() }
}