package com.example.formula1.feature_driver_standing.data.remote.dto

data class CurrentDto(
    val Circuit: Circuit,
    val Results: List<Result>,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)