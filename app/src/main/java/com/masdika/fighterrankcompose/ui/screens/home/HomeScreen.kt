package com.masdika.fighterrankcompose.ui.screens.home

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.components.TopAppBar
import com.masdika.fighterrankcompose.ui.components.icons.GridIcon
import com.masdika.fighterrankcompose.ui.components.icons.ListIcon
import com.masdika.fighterrankcompose.ui.screens.home.components.FighterList
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    isGridLayout: Boolean,
    onNavigateToDetail: (Int) -> Unit,
    onNavigateToProfileScreen: () -> Unit,
    onNavigateToSourceCodeScreen: () -> Unit,
    onChangeContentLayout: () -> Unit
) {
    val listState = rememberLazyListState()
    val gridState = rememberLazyGridState()

    Scaffold(
        topBar = {
            TopAppBar(
                onNavigateToProfileScreen = onNavigateToProfileScreen,
                onNavigateToSourceCodeScreen = onNavigateToSourceCodeScreen,
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = !listState.isScrollInProgress && !gridState.isScrollInProgress,
                enter = fadeIn(
                    animationSpec = tween(durationMillis = 100)
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 100)
                )
            ) {
                FloatingActionButton(
                    onClick = {
                        onChangeContentLayout()
                    },
                    containerColor = MainRed.copy(0.75f),
                    contentColor = Color.White,
                ) {
                    Icon(
                        imageVector = if (isGridLayout) ListIcon else GridIcon,
                        contentDescription = "",
                    )
                }
            }
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (uiState) {
                is HomeUIState.Loading -> {
                    CircularProgressIndicator(color = MainRed)
                }

                is HomeUIState.Success -> {
                    FighterList(
                        fighters = uiState.fighters,
                        onNavigateToDetail = onNavigateToDetail,
                        modifier = Modifier.fillMaxSize(),
                        isGridLayout = isGridLayout,
                        fighterListState = listState,
                        fighterGridState = gridState
                    )
                }

                is HomeUIState.Error -> {
                    Text(
                        text = stringResource(R.string.failed_to_load_fighters),
                        fontFamily = BebasNeue,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = true
                            ), lineHeightStyle = LineHeightStyle(
                                trim = LineHeightStyle.Trim.Both,
                                alignment = LineHeightStyle.Alignment.Top,
                            )
                        ),
                    )
                }
            }
        }

    }
}

@Preview(
    name = "Home Screen Success Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Success Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenSuccessPreview() {
    FighterRankComposeTheme {
        val mockFighters = listOf(
            Fighter(
                id = 1,
                image = "",
                name = "Islam Makhachev",
                division = "Lightweight",
                description = "A dominant lightweight champion from Dagestan, known for his suffocating grappling and sambo skills.",
                wins = 326,
                losses = 1,
                draws = 0,
                strikeAccuracy = 60.2,
                takedownAccuracy = 61.1,
                knockOutWins = 5,
                submissionWins = 11,
                title = "Lightweight Champion",
                p4pRank = 1
            ),
            Fighter(
                id = 2,
                image = "",
                name = "Alex Pereira",
                division = "Light Heavyweight",
                description = "A terrifying striker with immense power, holding championships in two divisions.",
                wins = 11,
                losses = 3,
                draws = 0,
                strikeAccuracy = 62.5,
                takedownAccuracy = 50.0,
                knockOutWins = 9, submissionWins = 0,
                title = "Poatan",
                p4pRank = 2
            )
        )

        HomeScreen(
            uiState = HomeUIState.Success(mockFighters),
            isGridLayout = false,
            onNavigateToDetail = {},
            onNavigateToProfileScreen = {},
            onNavigateToSourceCodeScreen = {},
            onChangeContentLayout = {}
        )
    }
}

@Preview(
    name = "Home Screen Loading Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Loading Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenLoadingPreview() {
    FighterRankComposeTheme {
        HomeScreen(
            uiState = HomeUIState.Loading,
            isGridLayout = false,
            onNavigateToDetail = {},
            onNavigateToProfileScreen = {},
            onNavigateToSourceCodeScreen = {},
            onChangeContentLayout = {}
        )
    }
}

@Preview(
    name = "Home Screen Error Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Home Screen Error Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenErrorPreview() {
    FighterRankComposeTheme {
        HomeScreen(
            uiState = HomeUIState.Error(stringResource(R.string.failed_to_load_fighters)),
            isGridLayout = false,
            onNavigateToDetail = {},
            onNavigateToProfileScreen = {},
            onNavigateToSourceCodeScreen = {},
            onChangeContentLayout = {}
        )
    }
}