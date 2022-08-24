package com.example.formula1.feature_constructor_standing.data.mapper

import com.example.formula1.feature_constructor_standing.data.dtos.ResultDto
import com.example.formula1.feature_constructor_standing.domain.model.Result

internal fun ResultDto.toDomain(): Result{
    return Result(
        this.points,
        this.position,
        this.teamName
    )
}