package com.example.formula1.data.network.mapper

import com.example.formula1.data.network.dto.CurrentDto
import com.example.formula1.data.network.dto.DriversDto
import com.example.formula1.domain.models.Current
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


fun CurrentDto.toCurrent(): Current {
    return Current(
        Circuit =Circuit,
        Results = Results,
        raceName = raceName,
        round = round,
        season = season,
        url = url
    )
}