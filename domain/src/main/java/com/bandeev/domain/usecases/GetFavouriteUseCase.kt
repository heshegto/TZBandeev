package com.bandeev.domain.usecases

import com.bandeev.domain.models.Course
import com.bandeev.domain.repository.CourseStorage

class GetFavouriteUseCase(val courseStorage: CourseStorage) {
    fun execute(): List<Course> {
        return courseStorage.readAll()
    }
}