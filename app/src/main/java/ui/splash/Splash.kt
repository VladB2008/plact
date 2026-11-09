package ui.splash



import androidx.compose.foundation.Image
import androidx.compose.foundation.background


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.HomeScreen

@Composable
fun Splash(modifier: Modifier = Modifier
    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeScreen)
    ) {
    Column (modifier=modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.messeg),
            contentDescription = "",
            modifier = Modifier
                .width(56.86.dp)
                .height(52.28.dp)
        )
        Spacer(modifier = Modifier.height(15.53.dp))
        Text(text = "GAAMETIME", color = Color.White, fontSize = 17.78 .sp)
        Spacer(modifier = Modifier.height(8.83.dp))
        Text(text = "CONNECT WITH YOUR REALITY", color = Color.White, fontSize =6.44.sp )

        Spacer(modifier = Modifier.height(266.55.dp))
    }
        Image(
            painter =  painterResource(R.drawable.grups),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()


        )

    }
}


