package com.example.formula1.feature_grandpix.presentation.grandpix_winners


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formula1.feature_grandpix.domain.models.GrandPix
import com.example.formula1.ui.theme.DarkGray
import com.example.formula1.ui.theme.Teal200


@Composable
fun GrandPixListItem(grandpix: GrandPix) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp,
        backgroundColor = DarkGray
    ) {
        Box(modifier = Modifier.height(150.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "${grandpix.grandPrix} Grandpix",
                    style = MaterialTheme.typography.body1,
                    color = Teal200
                )
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 150f
                    )
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp),

            ) {
                Text(
                    text = "Name           ${grandpix.driver}",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )

                Text(
                    text = "Team           ${grandpix.team}",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )

                Text(
                    text = "Laps             ${grandpix.laps} Laps",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )

            }
        }
    }
}


@Preview
@Composable
fun UserPreview() {
    GrandPixListItem(grandpix = GrandPix("Hamiliton","","50","Mercedes"))
}

