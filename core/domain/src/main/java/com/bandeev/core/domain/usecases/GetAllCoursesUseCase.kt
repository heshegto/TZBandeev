package com.bandeev.core.domain.usecases

import com.bandeev.core.domain.models.CourseList
import com.bandeev.core.domain.repository.CoursesFromNet

class GetAllCoursesUseCase(val coursesFromNet: CoursesFromNet) {
    suspend fun execute(): CourseList {
        return coursesFromNet.getAllCourses()
    }
}
