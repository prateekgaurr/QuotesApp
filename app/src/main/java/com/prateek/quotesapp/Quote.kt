package com.prateek.quotesapp

import com.google.gson.annotations.SerializedName

data class Quote(@SerializedName("text") val text : String, @SerializedName("from") val author: String)
