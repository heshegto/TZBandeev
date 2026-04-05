package com.bandeev.all_courses.data

import com.bandeev.product_item.models.ProductList
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("u/0/uc")
    suspend fun getProducts(
        @Query("id") id: String,
        @Query("export") export: String
    ): ProductList
}