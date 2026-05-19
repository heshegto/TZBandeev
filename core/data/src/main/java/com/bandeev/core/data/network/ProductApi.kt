package com.bandeev.core.data.network

import com.bandeev.core.domain.models.CourseList
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductApi {
    @GET()
    suspend fun getCourses(
        @Url url: String
    ): CourseList
}