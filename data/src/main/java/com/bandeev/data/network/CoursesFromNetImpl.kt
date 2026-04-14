package com.bandeev.data.network

import com.bandeev.domain.models.CourseList
import com.bandeev.domain.repository.CoursesFromNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoursesFromNetImpl: CoursesFromNet {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://drive.usercontent.google.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val productApi: ProductApi = retrofit.create(ProductApi::class.java)
    override suspend fun getAllCourses(): CourseList {
        return withContext(Dispatchers.IO) {
            productApi.getProducts("15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q", "download")
        }
    }
}