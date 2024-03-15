package com.stankin.lab2.calendar

import java.util.Date

data class CalendarEventItem(
    val name: String,
    val city: String,
    val date: Date,
    val isActive: Boolean
)