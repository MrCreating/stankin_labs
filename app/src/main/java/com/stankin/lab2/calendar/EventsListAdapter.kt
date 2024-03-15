package com.stankin.lab2.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stankin.lab2.R

class EventsListAdapter(private val events: MutableList<CalendarEventItem>) : RecyclerView.Adapter<EventListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListHolder {
        return EventListHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.calendar_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventListHolder, position: Int) {
        holder.bind(events[position])
    }

    fun addEvent(event: CalendarEventItem) {
        events.add(itemCount, event)
        notifyItemInserted(itemCount)
    }
}