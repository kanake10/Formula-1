package com.example.formula1.feature_driver_standing.presentation.driversstanding


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.formula1.feature_driver_standing.domain.models.Driver
import com.example.formula1.ui.TopBar
import com.example.formula1.ui.theme.Teal200
import com.example.formula1.ui.theme.TextWhite


@Composable
fun DriversListItem(drivers: Driver) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${drivers.POS}     ${drivers.Name} (${drivers.Country})",
            style = MaterialTheme.typography.body1,
            color = TextWhite
        )
        Text(
            text = "${drivers.PTS} PTS",
            fontStyle = FontStyle.Italic,
            color = Teal200,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }

}