package com.example.myapplication.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class Event(
    val id:Int,
    val name:String,
    val category:String,
    val date:String,
    val place: String,

    val description:String ="хорошее место провождения. Откройте для себя новые горизонты города ",

){

    var isLiked by mutableStateOf(false)
}

