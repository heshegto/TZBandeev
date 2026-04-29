package com.bandeev.domain.usecases

import com.bandeev.domain.repository.CourseLocalStorage

class GetFavouriteIdsUseCase(val localStorage: CourseLocalStorage) {
    fun execute(): List<Int> {
        return localStorage.readIds()
    }
}