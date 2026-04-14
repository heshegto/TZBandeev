package com.bandeev.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bandeev.domain.models.Course
import com.bandeev.domain.models.CourseList
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class CourseAdapter(
    var dataSet: CourseList,
    private val onMoreClick: (Course) -> Unit,
    private val onFavouriteClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseViewHolder>() {

    private val formatter = DateTimeFormatter.ofPattern(
        "d MMMM yyyy",
        Locale.getDefault()
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_course, viewGroup, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CourseViewHolder, position: Int) {
        val product = dataSet.courses[position]
        viewHolder.title.text = product.title
        viewHolder.text.text = product.text
        viewHolder.price.text = product.price
        viewHolder.rate.text = product.rate
        viewHolder.startDate.text = LocalDate.parse(product.startDate).format(formatter)
        viewHolder.publishDate = LocalDate.parse(product.publishDate)
        viewHolder.id = product.id
        viewHolder.btnFavourite.isSelected = product.hasLike

        viewHolder.tvMore.setOnClickListener { onMoreClick(product) }
        viewHolder.btnFavourite.setOnClickListener {
            val newState = !it.isSelected
            it.isSelected = newState
            onFavouriteClick(product.copy(hasLike = newState))
        }
    }

    fun updateData(newData: CourseList) {
        this.dataSet = newData
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataSet.getSize()
}
