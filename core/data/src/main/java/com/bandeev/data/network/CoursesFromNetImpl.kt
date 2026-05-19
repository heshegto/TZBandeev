package com.bandeev.data.network

import com.bandeev.data.BuildConfig
import com.bandeev.domain.models.CourseList
import com.bandeev.domain.repository.CoursesFromNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoursesFromNetImpl: CoursesFromNet {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productApi: ProductApi = retrofit.create(ProductApi::class.java)

    override suspend fun getAllCourses(): CourseList {
        return withContext(Dispatchers.IO) {
            // Передаем только относительный путь, Retrofit сам приклеит его к baseUrl
            productApi.getCourses(BuildConfig.PATH_URL)
        }
    }
}
