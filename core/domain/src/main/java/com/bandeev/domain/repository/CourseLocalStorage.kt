package com.bandeev.domain.repository

import com.bandeev.domain.models.Course
import com.bandeev.domain.models.CourseList

interface CourseLocalStorage {
    fun readAll(): CourseList
    fun readIds(): List<Int>
    fun add(course: Course)
    fun delete(course: Course)
    fun contains(course: Course): Boolean
    fun contains(id: Int): Boolean
}
