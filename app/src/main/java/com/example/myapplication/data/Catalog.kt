package com.example.myapplication.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object Catalog {
    var opened by mutableStateOf<Event?>(null)

    val likes get() = events.count{it.isLiked}

    var search by mutableStateOf("")

     var category by mutableStateOf(categories[0])

    val show get() = events.filter{eventoll ->

        val searchSpacer = search.trim()

        (category == categories[0] || eventoll.category ==category) &&
                (eventoll.name.contains(searchSpacer,ignoreCase =true)

                        ||
                        eventoll.place.contains(searchSpacer, ignoreCase = true))
    }

    fun reset() {search =""; category = categories[0]}
}