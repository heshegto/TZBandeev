package com.bandeev.data.network

import com.bandeev.domain.models.CourseList
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductApi {
    @GET()
    suspend fun getCourses(
        @Url url: String
    ): CourseList
}