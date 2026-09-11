package com.example.composenavigationseatwork.screens

sealed class Screen(val route: String) {
    data object Home : Screen("home")

    data object Details : Screen("details")
}