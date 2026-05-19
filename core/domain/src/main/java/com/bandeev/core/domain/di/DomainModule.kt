package com.bandeev.core.domain.di

import com.bandeev.core.domain.usecases.GetAllCoursesUseCase
import com.bandeev.core.domain.usecases.GetFavouriteIdsUseCase
import com.bandeev.core.domain.usecases.GetFavouriteUseCase
import com.bandeev.core.domain.usecases.PushFavouriteUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCoursesUseCase> { GetAllCoursesUseCase(coursesFromNet = get()) }
    factory<GetFavouriteIdsUseCase> { GetFavouriteIdsUseCase(localStorage = get()) }
    factory<GetFavouriteUseCase> { GetFavouriteUseCase(localStorage = get()) }
    factory<PushFavouriteUseCase> { PushFavouriteUseCase(localStorage = get()) }
}