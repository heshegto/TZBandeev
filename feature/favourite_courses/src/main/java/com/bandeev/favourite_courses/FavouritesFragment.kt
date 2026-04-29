package com.bandeev.favourite_courses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bandeev.core.course.CourseAdapter
import com.bandeev.domain.models.Course
import kotlinx.coroutines.launch
import kotlin.getValue
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import androidx.lifecycle.repeatOnLifecycle


class FavouritesFragment: Fragment(R.layout.favourite_fragment_layout) {
    private val viewModel: FavouriteViewModel by viewModel()

    private val adapter: CourseAdapter by inject {
        parametersOf(
            { course: Course -> viewModel.onMoreClicked(course) },
            { course: Course -> viewModel.onFavouriteClicked(course) }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycleView = view.findViewById<RecyclerView>(R.id.rcView_main)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.courses.collect { courses ->
                    adapter.updateData(courses)
                }
            }
        }
    }
}