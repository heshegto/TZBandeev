package com.bandeev.product_item

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var id: Int = -1
    val title: TextView = view.findViewById(R.id.tv_title)
    val text: TextView = view.findViewById(R.id.tv_description)
    val price: TextView = view.findViewById(R.id.tv_price)
    val rate: TextView = view.findViewById(R.id.tv_rate)
    val startDate: TextView = view.findViewById(R.id.tv_date)
    var hasLike: Boolean = false
    var publishDate: LocalDate = LocalDate.MIN
}