package com.example.myapplication.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Catalog
import com.example.myapplication.data.Event
import com.example.myapplication.ui.theme.Accent

@Composable
fun DetailScreen(event: Event) {
var showForm by remember { mutableStateOf(false) }
    var signUp by remember {mutableStateOf(false)}

    BackHandler { Catalog.opened = null }

    Column(){
        Row(Modifier.height(56.dp)){
            IconBtn(Icons.Filled.ArrowBack, "Назад") { Catalog.opened = null }
            Title("Событие")
            HeartButton(event)
        }

        Box(Modifier.fillMaxWidth().height(180.dp).background(Accent))
        Title(event.name)
        Text(event.date)
        Text(event.place)
        Text(event.description)

        if(signUp){
            Text("Вы записаны на событие: ${event.name}")
        }
        AppButton("Записаться") {showForm=true }
    }









}
