package com.example.formula1.feature_constructor_standing.data.dtos

import com.google.gson.annotations.SerializedName

data class ResultDto(
    val points: String,
    val position: Int,
    val season: String,
    @SerializedName("team_name")
    val teamName: String
)