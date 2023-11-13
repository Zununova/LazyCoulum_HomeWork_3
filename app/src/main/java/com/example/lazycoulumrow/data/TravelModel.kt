package com.example.lazycoulumrow.data

data class TravelModel(
    val imageData: String,
    val placeCall: String,
    val stars: Double,
    val country: String,
    val city: String,
    val money: Int,
    val fromDay: Int,
    val beforeDay: Int,
    val month: String,
    val year: Int
)
