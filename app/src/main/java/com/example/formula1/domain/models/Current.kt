package com.example.formula1.domain.models

import com.example.formula1.data.network.dto.Circuit
import com.example.formula1.data.network.dto.Result

data class Current(
    val Circuit: Circuit,
    val Results: List<Result>,
    val raceName: String,
    val round: String,
    val season: String,
    val url: String
)
