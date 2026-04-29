package com.bandeev.domain.models

/**
 * Data model contain several courses
 *
 * @property courses List of courses
 */
data class CourseList(
    private val courses: List<Course>
) {
    companion object {
        fun getEmpty(): CourseList {
            return CourseList(emptyList())
        }
    }
    fun getSize(): Int{
        return courses.size
    }
    fun toList(): List<Course> = courses
}