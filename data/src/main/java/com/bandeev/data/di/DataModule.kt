package com.bandeev.data.di

import com.bandeev.data.network.CoursesFromNetImpl
import com.bandeev.data.storage.CourseStorageImpl
import com.bandeev.domain.repository.CourseStorage
import com.bandeev.domain.repository.CoursesFromNet
import org.koin.dsl.module


val dataModule = module {
    // Storage
    single<CourseStorage> { CourseStorageImpl(get()) }

    // Network
    single<CoursesFromNet> { CoursesFromNetImpl() }
}