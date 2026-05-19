package com.bandeev.domain.usecases

import com.bandeev.domain.models.CourseList
import com.bandeev.domain.repository.CourseLocalStorage

class GetFavouriteUseCase(val localStorage: CourseLocalStorage) {
    fun execute(): CourseList {
        return localStorage.readAll()
    }
}