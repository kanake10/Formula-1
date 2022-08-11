package com.example.formula1.feature_current_standing.data.mappers

import com.example.formula1.feature_current_standing.data.dto.CurrentDto
import com.example.formula1.feature_current_standing.domain.models.Current

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