package com.bandeev.core.domain.usecases

import com.bandeev.core.domain.repository.CourseLocalStorage

class GetFavouriteIdsUseCase(val localStorage: CourseLocalStorage) {
    fun execute(): List<Int> {
        return localStorage.readIds()
    }
}