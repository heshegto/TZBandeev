package com.bandeev.domain.repository

import com.bandeev.domain.models.Course

interface CourseStorage {
    fun readAll(): List<Course>
    fun readIds(): List<Int>
    fun add(course: Course)
    fun delete(course: Course)
}
