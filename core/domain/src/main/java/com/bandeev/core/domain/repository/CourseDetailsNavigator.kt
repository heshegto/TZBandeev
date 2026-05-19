package com.bandeev.core.domain.repository

import com.bandeev.core.domain.models.Course

/**
 * Interface for navigation to course details. Should open new fragment with course details.
 */
fun interface CourseDetailsNavigator {
    fun navigateToCourseDetails(course: Course)
}