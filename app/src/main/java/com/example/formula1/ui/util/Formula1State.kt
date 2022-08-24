package com.example.formula1.ui.util


import com.example.formula1.feature_constructor_standing.domain.model.Result
import com.example.formula1.feature_driver_standing.domain.models.Driver


data class Formula1State(
    val isLoading: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val constructor: List<Result> = emptyList(),
    val error: String = ""
)