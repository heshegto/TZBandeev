package com.bandeev.all_courses.data

import com.bandeev.product_item.ProductCard
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.withContext


class GetAllCourses {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://drive.usercontent.google.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val productApi: ProductApi = retrofit.create(ProductApi::class.java)
    suspend fun getCourses (): List<ProductCard>{
        return withContext(Dispatchers.IO) {
            productApi.getProducts("15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q", "download")
        }.courses
    }
}