package com.bandeev.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CourseEntity::class], version = 1)
abstract class CourseDatabase : RoomDatabase() {
    abstract fun getDao(): CourseDao
}