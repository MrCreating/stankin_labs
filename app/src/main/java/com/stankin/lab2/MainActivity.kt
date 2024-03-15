package com.stankin.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.stankin.lab2.calendar.CalendarEventItem
import com.stankin.lab2.calendar.DialogFragment
import com.stankin.lab2.calendar.EventsListAdapter
import com.stankin.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DialogFragment.OnEventAddedListener {

    private lateinit var binding: ActivityMainBinding

    private val eventsList = mutableListOf<CalendarEventItem>()

    private lateinit var adapter: EventsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.addEvent.setOnClickListener {
            val dialog = DialogFragment()
            dialog.show(supportFragmentManager, "AddEventDialog")
        }

        val list: RecyclerView = findViewById(R.id.calendar_events_list)
        val adapter = EventsListAdapter(eventsList)
        list.adapter = adapter
        this.adapter = adapter
    }

    override fun onEventAdded(event: CalendarEventItem) {
        eventsList.add(event)
        adapter.addEvent()
    }
}