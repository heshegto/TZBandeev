package com.bandeev.domain.repository

import com.bandeev.domain.models.Course

/**
 * Interface for navigation to course details. Should open new fragment with course details.
 */
fun interface CourseDetailsNavigator {
    fun navigateToCourseDetails(course: Course)
}