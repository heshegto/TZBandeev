package com.bandeev.tz.navigation

import com.bandeev.core.domain.models.Course
import com.bandeev.core.domain.repository.CourseDetailsNavigator

class CourseDetailsNavigatorImpl : CourseDetailsNavigator {
    private var navigationAction: ((Course) -> Unit)? = null

    fun bind(action: (Course) -> Unit) {
        this.navigationAction = action
    }

    fun unbind() {
        this.navigationAction = null
    }

    override fun navigateToCourseDetails(course: Course) {
        navigationAction?.invoke(course)
    }
}