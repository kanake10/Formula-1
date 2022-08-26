package com.example.formula1.ui.util


import com.example.formula1.feature_constructor_standing.domain.model.Result
import com.example.formula1.feature_driver_standing.domain.models.Driver
import com.example.formula1.feature_grandpix.domain.models.GrandPix


data class Formula1State(
    val isLoading: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val constructor: List<Result> = emptyList(),
    val isRefreshing: Boolean = false,
    val grandpix: List<GrandPix> = emptyList(),
    val error: String = ""
)