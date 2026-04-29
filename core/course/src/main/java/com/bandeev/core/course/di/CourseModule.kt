package com.bandeev.core.course.di

import com.bandeev.core.course.CourseAdapter
import com.bandeev.domain.models.Course
import com.bandeev.domain.models.CourseList
import org.koin.dsl.module

val courseModule = module {

    factory { (onMore: (Course) -> Unit, onFav: (Course) -> Unit) ->
        CourseAdapter(
            dataSet = CourseList.getEmpty(),
            onMoreClick = onMore,
            onFavouriteClick = onFav
        )
    }
}