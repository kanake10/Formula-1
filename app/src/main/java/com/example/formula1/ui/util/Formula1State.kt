package com.example.formula1.ui.util

import com.example.formula1.domain.models.Current
import com.example.formula1.domain.models.Driver

data class Formula1State(
    val isLoading: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val current: List<Current> = emptyList(),
    val error: String = ""
)