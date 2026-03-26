package com.bandeev.all_courses.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bandeev.all_courses.R
import com.bandeev.all_courses.data.GetAllCourses
import com.bandeev.product_item.MyAdapter
import kotlinx.coroutines.launch

class AllCoursesFragment : Fragment(R.layout.main_fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView = view.findViewById<RecyclerView>(R.id.rcView_main)
        val adapter = MyAdapter(listOf())
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = adapter

        val getAllCourses =GetAllCourses()
        viewLifecycleOwner.lifecycleScope.launch {
            val courses = getAllCourses.getCourses()
            adapter.updateData(courses)
        }
    }
}