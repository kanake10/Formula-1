package com.example.formula1.feature_driver_standing.data.remote.mapper

import com.example.formula1.feature_driver_standing.data.remote.dto.DriversDto
import com.example.formula1.feature_driver_standing.domain.models.Driver

fun DriversDto.toDriver(): Driver {
    return Driver(
        Car = Car,
        Country = Country,
        Name = Name,
        POS = POS,
        PTS = PTS
    )
}

