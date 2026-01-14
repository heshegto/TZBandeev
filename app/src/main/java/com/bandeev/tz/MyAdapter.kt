package com.bandeev.tz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class MyAdapter (var dataSet: List<ProductCard>) : RecyclerView.Adapter<MyAdapter.MyViewHolder> (){
    private val formatter = DateTimeFormatter.ofPattern(
        "d MMMM yyyy",
        Locale.getDefault()
    )
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val text: TextView = view.findViewById(R.id.tv_description)
        val price: TextView = view.findViewById(R.id.tv_price)
        val rate: TextView = view.findViewById(R.id.tv_rate)
        val startDate: TextView = view.findViewById(R.id.tv_date)
        var hasLike: Boolean = false
        var publishDate: LocalDate = LocalDate.MIN
        var id: Int = -1

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_item, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position].title
        viewHolder.text.text = dataSet[position].text
        viewHolder.price.text = dataSet[position].price
        viewHolder.rate.text = dataSet[position].rate
        viewHolder.startDate.text = LocalDate.parse(dataSet[position].startDate).format(formatter)
        viewHolder.hasLike = dataSet[position].hasLike
        viewHolder.publishDate = LocalDate.parse(dataSet[position].publishDate)
        viewHolder.id = dataSet[position].id
    }

    fun updateData(newData: List<ProductCard>) {
        this.dataSet = newData
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataSet.size

}