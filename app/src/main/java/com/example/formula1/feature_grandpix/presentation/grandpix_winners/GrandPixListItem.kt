package com.example.formula1.feature_grandpix.presentation.grandpix_winners


import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formula1.feature_grandpix.domain.models.GrandPix


@Composable
fun GrandPixListItem(grandpix: GrandPix) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "${grandpix.grandPrix} Grandpix",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),

    ) {
        Text(
            text = "Name :${grandpix.driver}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Team :${grandpix.team}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Laps :${grandpix.laps} Laps",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun UserPreview() {
    GrandPixListItem(grandpix = GrandPix("Hamiliton","","50","Mercedes"))
}

