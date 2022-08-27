package com.example.formula1.feature_driver_standing.data.remote.mapper

import com.example.formula1.feature_driver_standing.data.dto.DriversDto
import com.example.formula1.feature_driver_standing.domain.models.Driver


/**
 * we can map all our three fields to call them as one var in text view in driverlistitem composable
 */
fun DriversDto.toDriver(): Driver {
    return Driver(
        Car = Car,
        Country = Country,
        Name = Name,
        POS = POS,
        PTS = PTS
    )
}

