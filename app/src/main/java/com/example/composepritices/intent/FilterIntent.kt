package com.example.composepritices.intent

sealed class Intent {
    data object LoadingIntent :Intent()
    data class FilterIntent(val name:String) :Intent()
}