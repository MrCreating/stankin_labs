package com.stankin.lab2.calendar

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.stankin.lab2.R

class EventsListAdapter(private val events: MutableList<CalendarEventItem>, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<EventListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListHolder {
        return EventListHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.calendar_item, parent, false),
            onItemClicked
        )
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventListHolder, position: Int) {
        val event = events[position]
        holder.bind(event)

        holder.itemView.findViewById<ImageButton>(R.id.delete_event).setOnClickListener {
            showDeleteConfirmationDialog(holder.itemView.context) {
                events.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun showDeleteConfirmationDialog(context: Context, onDeleteConfirmed: () -> Unit) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null)
        val alertDialogBuilder = AlertDialog.Builder(context)
            .setView(dialogView)
            .setPositiveButton("Да") { _, _ ->
                onDeleteConfirmed()
            }
            .setNegativeButton("Нет") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        alertDialogBuilder.show()
    }

    fun addEvent() {
        notifyItemInserted(itemCount)
    }
}