package com.bandeev.data.network

import com.bandeev.domain.models.CourseList
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("u/0/uc")
    suspend fun getProducts(
        @Query("id") id: String,
        @Query("export") export: String
    ): CourseList
}