package com.prateek.quotesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prateek.quotesapp.screens.CompleteListScreen
import com.prateek.quotesapp.screens.LoadingQuoteUI
import com.prateek.quotesapp.screens.QuoteDetailDisplayScreen
import com.prateek.quotesapp.screens.QuotesListScreen
import com.prateek.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadDataFromAssets(applicationContext)
        }

        setContent {
            App()
        }


    }


    @Composable
    fun App() {
        if (DataManager.isDataLoaded.value) {
            if (DataManager.currentPage.value == Pages.LISTING)
                CompleteListScreen(data = DataManager.data) {
                    DataManager.currentQuote = it
                    DataManager.switchPages()
                }
            else
                DataManager.currentQuote?.let {
                    QuoteDetailDisplayScreen(
                        quote = it,
                        shareQuote = {
                           shareQuote(this, quote = it)
                        }
                    )
                }
        } else {
            LoadingQuoteUI()
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}

fun shareQuote(context: Context, quote: Quote) {
    val shareIntent = Intent()
    shareIntent.action = Intent.ACTION_SEND
    shareIntent.type = "text/plain"
    shareIntent.putExtra(
        Intent.EXTRA_TEXT,
        "Hi! I have a beautiful quote for you. \n\n${quote?.text}\nThe author name is ${quote?.author}"
    );
    context.startActivity(Intent.createChooser(shareIntent, "Select an App"))
}


