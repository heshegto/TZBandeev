package com.bandeev.domain.di

import com.bandeev.domain.usecases.GetAllCoursesUseCase
import com.bandeev.domain.usecases.GetFavouriteIdsUseCase
import com.bandeev.domain.usecases.GetFavouriteUseCase
import com.bandeev.domain.usecases.PushFavouriteUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCoursesUseCase> { GetAllCoursesUseCase(coursesFromNet = get()) }
    factory<GetFavouriteIdsUseCase> { GetFavouriteIdsUseCase(localStorage = get()) }
    factory<GetFavouriteUseCase> { GetFavouriteUseCase(localStorage = get()) }
    factory<PushFavouriteUseCase> { PushFavouriteUseCase(localStorage = get()) }
}