package com.bandeev.data.storage

import android.content.Context
import androidx.room.Room
import com.bandeev.domain.models.Course
import com.bandeev.domain.repository.CourseStorage


class CourseStorageImpl(context: Context): CourseStorage {
    val db = Room.databaseBuilder(
        context,
        CourseDatabase::class.java,
        "favourite_courses_db"
    ).build()
    val courseDao = db.getDao()

    override fun readAll(): List<Course> {
        return courseDao.selectAll().map { it.fromEntityToCourse() }
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

}