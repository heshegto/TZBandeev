package com.bandeev.domain.usecases

import com.bandeev.domain.repository.CourseStorage

class GetFavouriteIdsUseCase(val courseStorage: CourseStorage) {
    fun execute(): List<Int> {
        return courseStorage.readIds()
    }
}