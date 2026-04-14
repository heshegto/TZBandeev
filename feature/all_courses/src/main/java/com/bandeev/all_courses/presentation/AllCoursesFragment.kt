package com.bandeev.all_courses.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bandeev.all_courses.R
import com.bandeev.data.network.CoursesFromNetImpl
import com.bandeev.course.CourseAdapter
import kotlinx.coroutines.launch

class AllCoursesFragment : Fragment(R.layout.main_fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView = view.findViewById<RecyclerView>(R.id.rcView_main)
        val adapter = CourseAdapter(listOf())
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = adapter

        val getAllCourses =CoursesFromNetImpl()
        viewLifecycleOwner.lifecycleScope.launch {
            val courses = getAllCourses.getCourses()
            adapter.updateData(courses)
        }
    }
}