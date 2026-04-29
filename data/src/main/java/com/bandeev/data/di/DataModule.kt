package com.bandeev.data.di

import com.bandeev.data.network.CoursesFromNetImpl
import com.bandeev.data.storage.CourseLocalStorageImpl
import com.bandeev.domain.repository.CourseLocalStorage
import com.bandeev.domain.repository.CoursesFromNet
import org.koin.dsl.module


val dataModule = module {
    // Storage
    single<CourseLocalStorage> { CourseLocalStorageImpl(get()) }

    // Network
    single<CoursesFromNet> { CoursesFromNetImpl() }
}