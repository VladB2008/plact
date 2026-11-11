package com.example.myapplication.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object Catalog {
    var opened by mutableStateOf<Event?>(null)

    val likes get() = events.count{it.isLiked}

    var search by mutableStateOf("")

}