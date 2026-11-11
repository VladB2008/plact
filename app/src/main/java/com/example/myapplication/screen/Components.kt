package com.example.myapplication.screen


import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Catalog

import com.example.myapplication.data.Event
import com.example.myapplication.ui.theme.Accent

@Composable
fun Title(text:String) {
    Text(text, style = MaterialTheme.typography.titleLarge)
}

@Composable
fun IconBtn(icon: ImageVector, name: String,tint: Color = LocalContentColor.current, onClick:() -> Unit) {
    IconButton(onClick = onClick) {
        Icon(icon, name, tint = tint)
    }
}

@Composable
fun HeartButton(event: Event) {

    val icon = if (event.isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    IconBtn(icon, "избранное", tint = Accent) { event.isLiked = !event.isLiked }

}

@Composable
fun AppButton(text:String, onClick:() -> Unit) {
    Button(onClick=onClick, shape = MaterialTheme.shapes.extraSmall){
        Text(text)
    }
}

@Composable
fun FormField(label:String, value:String, onChange:(String) -> Unit) {

    OutlinedTextField(

        value = value,
        onValueChange = onChange,
        label = {Text(label)},
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun EventCard(event:Event) {
Card(onClick = { Catalog.opened =event}){
    ListItem(
        leadingContent = {Box(Modifier.size(96.dp).background(Accent))},
        overlineContent = {Text(event.category)},
        headlineContent = {Text(event.name)},
        supportingContent = {Text("${event.date}\n${event.place}")},
        trailingContent = {HeartButton(event)},
    )
}


    }

