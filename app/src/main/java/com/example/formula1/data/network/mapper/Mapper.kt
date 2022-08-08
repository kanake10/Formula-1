package com.example.formula1.data.network.mapper

import com.example.formula1.data.network.dto.DriversDto
import com.example.formula1.domain.models.Driver

fun DriversDto.toDriver(): Driver {
    return Driver(
        Car = Car,
        Country = Country,
        Name = Name,
        POS = POS,
        PTS = PTS
    )
}