package ui.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Blues

@Composable
fun Card(
    cardImage:Int,
    text1:String,
    text2:String,
    time: String,
    visit:String,
    isFavorite: Boolean  ,
    cardOnClick:() -> Unit,
    modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .background(Color.White, RoundedCornerShape(16.dp))
        .clip(
            RoundedCornerShape(16.dp)


        )
    ){
        Row(modifier = Modifier
            .padding(end = 10.dp)){
            Image(
painter = painterResource(id = cardImage),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 13.dp, top = 13.dp, start = 13.dp, bottom = 30.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .width(96.dp)
                    .height(96.dp)
                   ,
            )

            Column(modifier = modifier
                .padding(end=15.dp, top=13.dp)
            ) {
                Text(text=text1, fontSize = 14.sp, color= Blues,)

                Text(text=text2, fontSize = 16.sp, color= Color.Black,)

                Text(text=time, fontSize = 14.sp, color= Color.Gray,)

                Text(text=visit, fontSize = 14.sp, color= Color.Gray,)

            }
        }
        Icon(
          painter = painterResource(id = if(isFavorite) R.drawable.selected else R.drawable.serd),
            contentDescription = null,
tint = if (isFavorite) Color(0xFF4F46E5) else Color(0xFF4F46E5),
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 16.dp)
                .size(30.dp)
                .clickable { cardOnClick() }


        )
    }
}

@Composable
fun RelazyCart(
    favorite: List<Int>,
    onFavoriteToggle: (Int) -> Unit,
    modifier: Modifier = Modifier) {
    Card(
        R.drawable.group1,
        "ВЫСТАВКИ",
        "Ночь в музее",
        "12 ноября 18:00",
        "Музей города",

        isFavorite = favorite.contains(1),
        cardOnClick = { onFavoriteToggle(1) }
    )

    Card(
        R.drawable.group2,
        "ЛЕКЦИИ",
        "ИИ в дизайне",
        "14 ноября 19:00",
        "Технопарк",
        isFavorite = favorite.contains(2),
        cardOnClick = { onFavoriteToggle(2) }
    )

    Card(
        R.drawable.group3,
        "МАСТЕР-КЛАССЫ",
        "Глина и форма",
        "15 ноября 12:00",
        "Арт-центр",
        isFavorite = favorite.contains(3),
        cardOnClick = { onFavoriteToggle(3) })

}

