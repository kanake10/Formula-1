package com.example.formula1.feature_constructor_standing.presentation.constructorstanding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.formula1.feature_constructor_standing.domain.model.Result
import com.example.formula1.ui.theme.Teal200
import com.example.formula1.ui.theme.TextWhite

@Composable
fun ConstructorListItem(constructor : Result) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${constructor.position}. ${constructor.teamName}",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
            Text(
                text = "${constructor.points} PTS",
                fontStyle = FontStyle.Italic,
                color = Teal200,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
}