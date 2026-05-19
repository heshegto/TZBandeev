package com.bandeev.core.domain.repository

import com.bandeev.core.domain.models.CourseList

interface CoursesFromNet {
    suspend fun getAllCourses(): CourseList
}