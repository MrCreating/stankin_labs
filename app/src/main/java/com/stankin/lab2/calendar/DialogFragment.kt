package com.stankin.lab2.calendar

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.stankin.lab2.R
import java.util.*

class DialogFragment : DialogFragment() {
    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val dialogView = inflater.inflate(R.layout.add_event_dialog, null)

            builder.setView(dialogView)
                .setPositiveButton("Добавить") { _, _ ->
                    val name     = dialogView.findViewById<TextView>(R.id.name_input).text.toString()
                    val city     = dialogView.findViewById<TextView>(R.id.city_input).text.toString()
                    val date     = Date()
                    val isActive = dialogView.findViewById<CheckBox>(R.id.is_new_event).isChecked
                    val event    = CalendarEventItem(name, city, date, isActive = isActive)

                    (activity as? OnEventAddedListener)?.onEventAdded(event)
                }
                .setNegativeButton("Отмена") { dialog, _ ->
                    dialog.dismiss()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface OnEventAddedListener {
        fun onEventAdded(event: CalendarEventItem)
    }
}