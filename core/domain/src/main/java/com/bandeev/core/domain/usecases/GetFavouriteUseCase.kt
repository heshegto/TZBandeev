package com.bandeev.core.domain.usecases

import com.bandeev.core.domain.models.CourseList
import com.bandeev.core.domain.repository.CourseLocalStorage

class GetFavouriteUseCase(val localStorage: CourseLocalStorage) {
    fun execute(): CourseList {
        return localStorage.readAll()
    }
}