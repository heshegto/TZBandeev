package com.bandeev.all_courses.di

import com.bandeev.all_courses.presentation.AllCoursesViewModel
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
