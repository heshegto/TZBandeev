package com.bandeev.tz.di

import com.bandeev.domain.repository.CourseDetailsNavigator
import com.bandeev.tz.navigation.CourseDetailsNavigatorImpl
import org.koin.dsl.module

val mainModule = module {
    single { CourseDetailsNavigatorImpl() }
    single<CourseDetailsNavigator> { get<CourseDetailsNavigatorImpl>() }
}