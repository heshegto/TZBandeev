package com.bandeev.domain.usecases

import android.util.Log
import com.bandeev.domain.models.Course
import com.bandeev.domain.repository.CourseLocalStorage

class PushFavouriteUseCase(val localStorage: CourseLocalStorage) {
    suspend fun execute(course: Course) {
        if ((course.hasLike) and (localStorage.contains(course))) {
            delete(course)
        } else if (!(course.hasLike) and !(localStorage.contains(course))) {
            add(course)
        } else {
            Log.d("PushFavouriteUseCase", "Something went wrong")
        }
    }

    private suspend fun add(course: Course) {
        localStorage.add(course)
    }
    private suspend fun delete(course: Course) {
        localStorage.delete(course)
    }

}