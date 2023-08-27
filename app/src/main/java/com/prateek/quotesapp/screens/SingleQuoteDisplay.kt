package com.prateek.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prateek.quotesapp.DataManager
import com.prateek.quotesapp.Quote

@Composable
fun QuoteDetailDisplayScreen(quote: Quote, shareQuote : ()->Unit) {

    BackHandler {
        DataManager.switchPages()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Brush.linearGradient(listOf(Color.Yellow, Color.Blue))),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
            ) {

                Image(
                    imageVector = Icons.Outlined.FormatQuote,
                    contentDescription = "Quote Icon",
                    modifier = Modifier
                        .size(70.dp)
                        .rotate(180F),
                    colorFilter = ColorFilter.tint(Color.Black)
                )

                Text(
                    text = quote.text,
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )

                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth(0.3f)
                        .background(Color.LightGray)
                )

                Text(
                    text = quote.author,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 5.dp)
                )


                Row {

                    Image(imageVector = Icons.Rounded.ArrowBack,
                        colorFilter = ColorFilter.tint(Color.Blue),
                        contentDescription = "Back Button",
                        modifier = Modifier
                            .clickable { DataManager.switchPages() }
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Image(imageVector = Icons.Rounded.Share,
                        colorFilter = ColorFilter.tint(Color.Blue),
                        contentDescription = "Share Button",
                        modifier = Modifier
                            .clickable {
                                shareQuote()
                            }
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun generateQuoteScreenPreview() {
    QuoteDetailDisplayScreen(quote = Quote("Happiness is the key to Success", "Prateek Gaur"),{})
}