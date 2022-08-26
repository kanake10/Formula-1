package com.example.formula1.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.formula1.feature_constructor_standing.presentation.constructorstanding.ConstructorStandingScreen
import com.example.formula1.feature_driver_standing.presentation.driversstanding.DriversStandingScreen
import com.example.formula1.feature_grandpix.presentation.grandpix_winners.GrandPixStandingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Drivers.screen_route) {
        composable(BottomNavItem.Drivers.screen_route) {
            DriversStandingScreen()
        }
        composable(BottomNavItem.GrandPix.screen_route) {
            GrandPixStandingScreen()
        }
        composable(BottomNavItem.Constructors.screen_route) {
            ConstructorStandingScreen()
        }
    }
}