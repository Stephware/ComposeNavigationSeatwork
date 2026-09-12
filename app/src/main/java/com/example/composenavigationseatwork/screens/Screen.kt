package com.example.composenavigationseatwork.screens

sealed class Screen(val route: String) {
    data object Home : Screen("home")

    data object Details : Screen("details/{studentId}/{name}/{course}/{yearLevel}") {
        fun createRoute(
            studentId: String,
            name: String,
            course: String,
            yearLevel: String
        ): String {
            return "details/$studentId/$name/$course/$yearLevel"
        }
    }
}