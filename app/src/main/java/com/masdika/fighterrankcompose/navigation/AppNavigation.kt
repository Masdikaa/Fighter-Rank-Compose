package com.masdika.fighterrankcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.masdika.fighterrankcompose.ui.screens.detail.DetailScreen
import com.masdika.fighterrankcompose.ui.screens.detail.DetailViewModel
import com.masdika.fighterrankcompose.ui.screens.home.HomeScreen
import com.masdika.fighterrankcompose.ui.screens.home.HomeViewModel

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
            val viewModel = viewModel<HomeViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            HomeScreen(
                uiState = uiState,
                onNavigateToDetail = { fighterName ->
                    navController.navigate(Screen.Detail(fighterName = fighterName))
                },
                onNavigateToProfileScreen = {
                    // TODO: Implement navigation to profile screen
                },
                onNavigateToSourceCodeScreen = {
                    // TODO: Implement navigation to source code screen
                },
                onChangeContentLayout = {
                    // TODO: Implement FAB click action
                }
            )
        }

        // Detail Route
        composable<Screen.Detail> { backStackEntry ->
            val args = backStackEntry.toRoute<Screen.Detail>()
            val viewModel = viewModel<DetailViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = args.fighterName) {
                viewModel.findFighterByName(args.fighterName)
            }

            DetailScreen(
                uiState = uiState,
                onShareClick = {
                    // TODO: Implement Share Button click action
                }
            )
        }
    }
}