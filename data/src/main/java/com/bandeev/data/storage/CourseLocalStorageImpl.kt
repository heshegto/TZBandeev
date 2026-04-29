package com.bandeev.data.storage

import android.content.Context
import androidx.room.Room
import com.bandeev.domain.models.Course
import com.bandeev.domain.models.CourseList
import com.bandeev.domain.repository.CourseLocalStorage


class CourseLocalStorageImpl(context: Context): CourseLocalStorage {
    private val db = Room.databaseBuilder(
        context,
        CourseDatabase::class.java,
        "favourite_courses_db"
    ).build()
    private val courseDao = db.getDao()

    override fun readAll(): CourseList {
        return CourseList(courseDao.selectAll().map { it.fromEntityToCourse() })
    }

    override fun readIds(): List<Int> {
        return courseDao.selectAllIds()
    }

    override fun add(course: Course) {
        courseDao.insert(CourseEntity.fromCourseToEntity(course))
    }

    override fun delete(course: Course) {
        courseDao.delete(CourseEntity.fromCourseToEntity(course))
    }

    override fun contains(course: Course): Boolean {
        return this.contains(course.id)
    }

    override fun contains(id: Int): Boolean {
        return id in readIds()
    }

}