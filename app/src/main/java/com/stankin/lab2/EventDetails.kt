package com.stankin.lab2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.stankin.lab2.databinding.ActivityEventDetailsBinding

class EventDetails : AppCompatActivity() {

    private lateinit var binding: ActivityEventDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        val title = intent.getStringExtra("title")
        val city = intent.getStringExtra("city")
        val date = intent.getStringExtra("date")
        val isNewEvent = intent.getBooleanExtra("is_new_event", false)

        binding.toolbarLayout.title = title

        findViewById<TextView>(R.id.event_city_view).text =
            "Название: ${title}\nГород: ${city}\nВремя: ${date}\nНовое событие: ${if (isNewEvent) "Да" else "Нет"}"
    }
}