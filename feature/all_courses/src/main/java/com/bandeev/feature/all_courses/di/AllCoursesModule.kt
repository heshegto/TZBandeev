package com.bandeev.feature.all_courses.di

import com.bandeev.feature.all_courses.presentation.AllCoursesViewModel
import org.koin.dsl.module

val allCoursesModule = module {
    factory<AllCoursesViewModel> {
        AllCoursesViewModel(
            coursesRepository = get(),
            navigator = get(),
            pushFavouriteUseCase = get()
        )
    }
}
