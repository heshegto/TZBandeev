package com.bandeev.domain.usecases

import com.bandeev.domain.models.Course
import com.bandeev.domain.repository.CourseStorage

class PushFavouriteUseCase(val courseStorage: CourseStorage) {
    fun execute(course: Course) {
        if (course.hasLike) {
            delete(course)
        } else {
            add(course)
        }
    }

    private fun add(course: Course) {
        courseStorage.add(course)
    }
    private fun delete(course: Course) {
        courseStorage.delete(course)
    }

}