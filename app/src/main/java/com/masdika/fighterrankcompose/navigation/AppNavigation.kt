package com.masdika.fighterrankcompose.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.masdika.fighterrankcompose.FighterRankApplication
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.ViewModelFactory
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
    val application = LocalContext.current.applicationContext as FighterRankApplication
    val viewModelFactory = ViewModelFactory(application.repository)

    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier
    ) {
        // Home Route
        composable<Screen.Home> {
            val viewModel: HomeViewModel = viewModel(factory = viewModelFactory)
            val uiState by viewModel.uiState.collectAsState()
            var isGridLayout by rememberSaveable { mutableStateOf(false) }
            val sourceCodeUrl = stringResource(R.string.source_code_url)

            HomeScreen(
                uiState = uiState,
                isGridLayout = isGridLayout,
                onNavigateToDetail = { fighterId ->
                    navController.navigate(Screen.Detail(fighterId = fighterId))
                },
                onNavigateToProfileScreen = {
                    navController.navigate(Screen.About)
                },
                onNavigateToSourceCodeScreen = {
                    context.openUrl(sourceCodeUrl)
                },
                onChangeContentLayout = {
                    isGridLayout = !isGridLayout
                }
            )
        }

        // Detail Route
        composable<Screen.Detail> { backStackEntry ->
            val args = backStackEntry.toRoute<Screen.Detail>()
            val viewModel: DetailViewModel = viewModel(factory = viewModelFactory)
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = args.fighterId) {
                viewModel.findFighterById(args.fighterId)
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