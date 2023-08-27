package com.prateek.quotesapp

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import androidx.compose.runtime.mutableStateOf


object DataManager {

    var data = emptyArray<Quote>()

    var currentQuote : Quote? = null

    val currentPage = mutableStateOf(Pages.LISTING)

    var isDataLoaded = mutableStateOf(false)


    fun loadDataFromAssets(context: Context){
        val jsonString = context
            .resources
            .openRawResource(R.raw.quotes)
            .bufferedReader()
            .use { it.readText() }


        data = Gson().fromJson(jsonString, Array<Quote>::class.java)

        isDataLoaded.value = true
    }

    fun switchPages(){
        if(currentPage.value == Pages.LISTING)
            currentPage.value = Pages.DETAIL
        else
            currentPage.value = Pages.LISTING
    }

}