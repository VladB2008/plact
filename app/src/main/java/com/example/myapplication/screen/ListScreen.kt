package com.example.myapplication.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Catalog
import com.example.myapplication.data.categories
import com.example.myapplication.data.events
import com.example.myapplication.ui.theme.Accent

@Composable
fun ListsScreen() {

    LazyColumn{
        item{Row(modifier = Modifier.height(56.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
Text("События")
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(if (Catalog.likes>0){
                Icons.Filled.Favorite
                }else{
                    Icons.Filled.FavoriteBorder
                },
                    contentDescription = "Избранное",
                    tint = Accent)
                Text("${Catalog.likes}", )
            }
        }

        OutlinedTextField(
            value= Catalog.search,
            onValueChange = { Catalog.search = it},
            placeholder = {Text("найти событие или плоощадку" )} ,
            trailingIcon = {IconBtn(Icons.Filled.Close, "Очистить ") { Catalog.search=""}},
        shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth(),
        )

        LazyRow (horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(categories){ ollcategory ->
                FilterChip(
                    selected = Catalog.category == ollcategory,
                    onClick = { Catalog.category = ollcategory},
                    label = {Text(ollcategory)}
                )
            }
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(Catalog.show) { event1 -> EventCard((event1)) }
            if(Catalog.show.isEmpty()) {
                item {
                    Text("Ничего не найдено")
                    AppButton("сбросить поиск") { Catalog.reset() }
                }
            }
            }
        }
    }
}