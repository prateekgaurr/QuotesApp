package com.prateek.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.prateek.quotesapp.Quote

@Composable
fun QuotesListScreen(data: Array<Quote>, onClick : (quote : Quote)->Unit) {

    LazyColumn(
        content = {
            items(data) {
                ShowSingleQuoteListItem(quote = it, onClick = onClick)
            }
        }
    )

}


@Composable
@Preview(showSystemUi = true)
private fun previewQuotesListScreen() {
    QuotesListScreen(
        arrayOf(
            Quote("Happiness is the key to sucess.", "Prateek Gaur"),
            Quote("You will never succes until you take your first step", "Prateek Gaur"),
            Quote("The same type of thing is written in this Quote number 3", "Saurabh Joshi"),
            Quote(
                "World starts with tech so that you can start things up accordingly.",
                "Technical Guruji"
            ),
            Quote("Start with General Knowledge and go on further.", "Mohak Mangal"),
            Quote("Hum tumhe content denge tum hume fake hansi do. Hahahahahh..", "Lalit Shokeen")
        ), {}
    )
}