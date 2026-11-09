package ui.login


import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Create(
    screenImage:Int,
    text1:String,
    text2:String,
textButton: String="Skip",
    onClickCreate: () -> Unit,
    modifier: Modifier = Modifier) {

    Box(
        modifier = modifier

            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column() {

            Image(
                painter = painterResource(screenImage),
                contentDescription = ""
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(text = text1, color = Color(0xFFFA5075), fontSize = 72.sp)

            Spacer(modifier = modifier.height(20.dp))
            Text(text = text2, color = Color.Black, fontSize =63.sp )

            Spacer(modifier = modifier.height(20.dp))

            Text(text = textButton, color = Color(0xFFFA5075), fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = modifier.clickable{onClickCreate()}
                )


        }
    }
}
