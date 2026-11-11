package com.example.myapplication.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Catalog

@Composable
fun ListsScreen() {

    Column{
        Row(modifier = Modifier.height(56.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
Text("События")
            Icon(Icons.Filled.Favorite, contentDescription = "Избранное")
            Text("${Catalog.likes}")
        }

        OutlinedTextField(
            value= Catalog.search,
            onValueChange = { Catalog.search = it},
            placeholder = {Text("найти событие или плоощадку" )} ,
            trailingIcon = {IconBtn(Icons.Filled.Close, "Очистить ") { Catalog.search=""}},
        shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}