package com.bandeev.domain.models

data class CourseList(
    val courses: List<Course>
) {
    fun getSize(): Int{
        return courses.size
    }
}