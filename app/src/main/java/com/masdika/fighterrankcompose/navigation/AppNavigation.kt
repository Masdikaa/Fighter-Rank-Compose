package com.masdika.fighterrankcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.masdika.fighterrankcompose.ui.screens.detail.DetailScreen
import com.masdika.fighterrankcompose.ui.screens.home.HomeScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier
    ) {
        // Home Route
        composable<Screen.Home> {
            HomeScreen(
                onNavigateToDetail = {
                    navController.navigate(Screen.Detail(fighterName = it))
                }
            )
        }

        // Detail Route
        composable<Screen.Detail> { backStackEntry ->
            val args = backStackEntry.toRoute<Screen.Detail>()
            DetailScreen(fighterName = args.fighterName)
        }
    }
}