package com.bandeev.domain.repository

import com.bandeev.domain.models.CourseList

interface CoursesFromNet {
    suspend fun getAllCourses(): CourseList
}