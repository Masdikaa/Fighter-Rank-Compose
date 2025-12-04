package com.masdika.fighterrankcompose.navigation

import android.content.Context
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
import com.masdika.fighterrankcompose.ui.screens.about.AboutScreen
import com.masdika.fighterrankcompose.ui.screens.about.AboutViewModel
import com.masdika.fighterrankcompose.ui.screens.detail.DetailScreen
import com.masdika.fighterrankcompose.ui.screens.detail.DetailUIState
import com.masdika.fighterrankcompose.ui.screens.detail.DetailViewModel
import com.masdika.fighterrankcompose.ui.screens.home.HomeScreen
import com.masdika.fighterrankcompose.ui.screens.home.HomeViewModel
import com.masdika.fighterrankcompose.utils.openUrl
import com.masdika.fighterrankcompose.utils.shareContent

@Composable
fun AppNavigation(
    context: Context,
    navController: NavHostController,
    modifier: Modifier = Modifier
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
                    navController.navigate(Screen.About)
                },
                onNavigateToSourceCodeScreen = {
                    context.openUrl("https://github.com/Masdikaa/Fighter-Rank-Compose")
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
                    val fighter = (uiState as? DetailUIState.Success)?.fighter
                    if (fighter != null) {
                        context.shareContent(fighter.name, fighter.description)
                    }
                }
            )
        }

        // About Route
        composable<Screen.About> {
            val viewModel = viewModel<AboutViewModel>()
            val uiState by viewModel.uiState.collectAsState()

            AboutScreen(uiState)
        }
    }
}