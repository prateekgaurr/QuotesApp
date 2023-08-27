package com.prateek.quotesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prateek.quotesapp.Quote

@Composable
fun CompleteListScreen(data : Array<Quote>, onClick: (quote: Quote)->Unit ) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Column(
            modifier = Modifier
                .padding(20.dp)
        ){
            Text(
                text = "Quotes App",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive
            )
            Text(
                text = "made with compose",
                fontFamily = FontFamily.Monospace,
                fontStyle = FontStyle.Italic,
            )
        }


        QuotesListScreen(data = data, onClick = onClick)
    }


}


@Preview(showSystemUi = true)
@Composable
private fun displayUi(){
    CompleteListScreen(data = arrayOf(
        Quote("Happiness is the key to sucess.", "Prateek Gaur"),
        Quote("You will never succes until you take your first step", "Prateek Gaur"),
        Quote("The same type of thing is written in this Quote number 3", "Saurabh Joshi"),
        Quote(
            "World starts with tech so that you can start things up accordingly.",
            "Technical Guruji"
        ),
        Quote("Start with General Knowledge and go on further.", "Mohak Mangal"),
        Quote("Hum tumhe content denge tum hume fake hansi do. Hahahahahh..", "Lalit Shokeen")
    ), onClick = {})
}