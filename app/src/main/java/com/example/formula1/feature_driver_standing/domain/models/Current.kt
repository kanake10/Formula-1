package com.example.formula1.feature_driver_standing.domain.models

import com.example.formula1.feature_driver_standing.data.remote.dto.Circuit
import com.example.formula1.feature_driver_standing.data.remote.dto.Result

data class Current(
    val Circuit: Circuit,
    val Results: List<Result>,
    val raceName: String,
    val round: String,
    val season: String,
    val url: String
)
