package com.bandeev.favourite_courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bandeev.domain.models.Course
import com.bandeev.domain.models.CourseList
import com.bandeev.domain.repository.CourseDetailsNavigator
import com.bandeev.domain.usecases.GetFavouriteUseCase
import com.bandeev.domain.usecases.PushFavouriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavouriteViewModel(
    val getFavouriteUseCase: GetFavouriteUseCase,
    val navigator: CourseDetailsNavigator,
    val pushFavouriteUseCase: PushFavouriteUseCase
) : ViewModel() {

    private val _courses = MutableStateFlow(CourseList.getEmpty())
    val courses: StateFlow<CourseList> = _courses.asStateFlow()


    init {
        loadAllCourses()
    }

    fun loadAllCourses() {
        viewModelScope.launch {
            try {
                val result = getFavouriteUseCase.execute()
                _courses.value = result
            } catch (e: Exception) {
            } finally {
            }
        }
    }

    fun onMoreClicked(course: Course) {
        navigator.navigateToCourseDetails(course)
    }

    fun onFavouriteClicked(course: Course) {
        viewModelScope.launch(Dispatchers.IO) {
            pushFavouriteUseCase.execute(course)
            loadAllCourses()
        }
    }
}