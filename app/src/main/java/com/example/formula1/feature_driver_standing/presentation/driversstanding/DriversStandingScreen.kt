package com.example.formula1.feature_driver_standing.presentation.driversstanding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formula1.feature_driver_standing.presentation.viewmodel.DriversViewModel
import com.example.formula1.ui.TopBar
import com.example.formula1.ui.theme.DarkGray
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun DriversStandingScreen(
    viewModel: DriversViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefresh.collectAsState()

    Box(
        modifier = Modifier
            .background(DarkGray)
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Column {
            TopBar(title = "Drivers Standings")
            Spacer(Modifier.height(15.dp))
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                onRefresh = { viewModel.refresh() }) {

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.drivers) { drivers ->
                        DriversListItem(
                            drivers = drivers,
                        )
                        Spacer(Modifier.height(25.dp))
                    }
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

