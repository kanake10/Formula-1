package com.example.formula1.feature_driver_standing.data.remote.dto

data class Driver(
    val code: String,
    val dateOfBirth: String,
    val driverId: String,
    val familyName: String,
    val givenName: String,
    val nationality: String,
    val permanentNumber: String,
    val url: String
)