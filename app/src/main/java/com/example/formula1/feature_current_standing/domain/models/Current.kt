package com.example.formula1.feature_current_standing.domain.models

import com.example.formula1.feature_current_standing.data.dto.Circuit
import com.example.formula1.feature_current_standing.data.dto.Result

data class Current(
    val Circuit: Circuit,
    val Results: List<Result>,
    val raceName: String,
    val round: String,
    val season: String,
    val url: String
)
