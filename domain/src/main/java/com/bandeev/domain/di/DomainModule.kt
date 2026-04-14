package com.bandeev.domain.di

import com.bandeev.domain.usecases.GetAllCoursesUseCase
import com.bandeev.domain.usecases.GetFavouriteIdsUseCase
import com.bandeev.domain.usecases.GetFavouriteUseCase
import com.bandeev.domain.usecases.PushFavouriteUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCoursesUseCase> { GetAllCoursesUseCase(coursesFromNet = get()) }
    factory<GetFavouriteIdsUseCase> { GetFavouriteIdsUseCase(courseStorage = get()) }
    factory<GetFavouriteUseCase> { GetFavouriteUseCase(courseStorage = get()) }
    factory<PushFavouriteUseCase> { PushFavouriteUseCase(courseStorage = get()) }
}