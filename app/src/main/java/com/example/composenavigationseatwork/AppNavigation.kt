package com.example.composenavigationseatwork

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composenavigationseatwork.screens.Screen
import com.example.composenavigationseatwork.screens.details.DetailsScreen
import com.example.composenavigationseatwork.screens.home.HomeScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onViewDetails = { studentId, name, course, yearLevel ->
                    navController.navigate(
                        Screen.Details.createRoute(
                            studentId = studentId,
                            name = name,
                            course = course,
                            yearLevel = yearLevel
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.StringType
                },
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("course") {
                    type = NavType.StringType
                },
                navArgument("yearLevel"){
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val studentId =
                backStackEntry.arguments?.getString("studentId") ?: ""

            val name =
                backStackEntry.arguments?.getString("name") ?: ""

            val course =
                backStackEntry.arguments?.getString("course") ?: ""

            val yearLevel =
                backStackEntry.arguments?.getString("yearLevel") ?: ""

            DetailsScreen(
                studentId = studentId,
                name = name,
                course = course,
                yearLevel = yearLevel,
                onEdit = {
                    navController.popBackStack(
                        route = Screen.Home.route,
                        inclusive = false
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}