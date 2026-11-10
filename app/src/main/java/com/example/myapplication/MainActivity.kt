package com.example.myapplication

import android.R.attr.id
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Blues
import com.example.myapplication.ui.theme.MyApplicationTheme
import ui.Card.Card
import ui.Card.RelazyCart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {

    val favorite = remember { mutableStateListOf<Int>() }
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE5E7EB))
    ) {

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "События",
                    fontSize = 30.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
Icon(
    painter = if (favorite.isEmpty()){
        painterResource(R.drawable.serd)
    }else{
        painterResource(R.drawable.selected)
    },

    contentDescription = "Избранное",
    modifier = modifier.size(40.dp),
    tint =  Color(0xFF4F46E5),
)
Text(
    text="${favorite.size}",
    modifier = modifier.padding(start = 7.dp).align(Alignment.CenterVertically),
    fontSize = 30.sp,
    color = if(favorite.isEmpty()) Color.Transparent else Blues
)
                }
            }


            RelazyCart(
                modifier = modifier,
                favorite=favorite,
                onFavoriteToggle = { id ->
                    if (favorite.contains(id)) {
                        favorite.remove(id)
                    } else {
                        favorite.add(id)
                    }
                }
            )


        }

    }

}



