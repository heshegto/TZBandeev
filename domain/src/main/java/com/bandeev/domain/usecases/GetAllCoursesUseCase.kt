package com.bandeev.domain.usecases

import com.bandeev.domain.models.CourseList
import com.bandeev.domain.repository.CoursesFromNet

class GetAllCoursesUseCase(val coursesFromNet: CoursesFromNet) {
    suspend fun execute(): CourseList {
        return coursesFromNet.getAllCourses()
    }
}
