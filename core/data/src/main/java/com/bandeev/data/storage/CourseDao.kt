package com.bandeev.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun selectAll(): List<CourseEntity>

    @Query("SELECT id FROM courses")
    fun selectAllIds(): List<Int>

    @Insert
    fun insert(course: CourseEntity)

    @Delete
    fun delete(course: CourseEntity)
}