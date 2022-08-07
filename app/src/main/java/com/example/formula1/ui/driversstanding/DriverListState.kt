package com.example.formula1.ui.driversstanding

import com.example.formula1.domain.models.Driver

data class DriverListState(
    val isLoading: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val error: String = ""
)