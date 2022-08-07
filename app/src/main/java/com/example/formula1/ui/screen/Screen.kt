package com.example.formula1.ui.screen

sealed class Screen(val route: String) {
    object DriversStandingScreen: Screen("drivers_standing_screen")
}