package com.stankin.lab2.calendar

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stankin.lab2.R

class EventListHolder(itemView: View, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val nameView: TextView = itemView.findViewById(R.id.event_name)
    private val cityView: TextView = itemView.findViewById(R.id.event_city)
    private val dateView: TextView = itemView.findViewById(R.id.event_date)

    init {
        itemView.setOnClickListener { onItemClicked(adapterPosition) }
    }

    fun bind (item: CalendarEventItem) {
        nameView.text = item.name;
        cityView.text = item.city;
        dateView.text = item.date.toString();
    }
}