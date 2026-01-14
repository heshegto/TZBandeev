package com.bandeev.tz

import retrofit2.http.GET
import retrofit2.http.Query

data class ProductCard (
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String,
)

data class ProductList (
    val courses: List<ProductCard>
)

interface ProductApi {
    @GET("u/0/uc")
    suspend fun getProducts(
        @Query("id") id: String,
        @Query("export") export: String
    ): ProductList
}
