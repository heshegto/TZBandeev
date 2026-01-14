package com.bandeev.tz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment : Fragment(R.layout.main_fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView = view.findViewById<RecyclerView>(R.id.rcView_main)
        val adapter = MyAdapter(listOf())
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val productApi = retrofit.create(ProductApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) {
                productApi.getProducts("15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q", "download")
            }
            val courses = response.courses
            if (response != null) adapter.updateData(courses)
        }
    }
}