package com.example.formula1.data.network.dto

import com.example.formula1.domain.models.Driver

data class DriversDto(
    val Car: String,
    val Country: String,
    val Name: String,
    val POS: String,
    val PTS: String
)

fun DriversDto.toDriver(): Driver {
    return Driver(
        Car = Car,
        Country = Country,
        Name = Name,
        POS = POS,
        PTS = PTS
    )
}