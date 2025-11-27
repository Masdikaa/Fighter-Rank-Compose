package com.masdika.fighterrankcompose.ui.screens.home

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.source.loadFighters
import com.masdika.fighterrankcompose.ui.components.TopAppBar
import com.masdika.fighterrankcompose.ui.screens.home.components.FighterList
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = viewModel<HomeViewModel>()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                onNavigateToProfileScreen = { onShowDropDownMenu() },
                onNavigateToSourceCodeScreen = { onShowDropDownMenu() },
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        HomeContent(
            onNavigateToDetail = onNavigateToDetail,
            uiState = uiState,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HomeContent(
    onNavigateToDetail: (String) -> Unit,
    uiState: HomeUIState,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
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

fun onShowDropDownMenu() {
    Log.i("onShowDropDownMenu", "Clicked")
}

@Preview(
    name = "Loading State Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Loading State Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun HomeContentLoadingPreview() {
    FighterRankComposeTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    {}, {}
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            HomeContent(
                onNavigateToDetail = {},
                uiState = HomeUIState.Loading,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(
    name = "Success State Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Success State Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun HomeContentSuccessPreview() {
    FighterRankComposeTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    {}, {}
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            val fighters = loadFighters(LocalContext.current)
            HomeContent(
                onNavigateToDetail = {},
                uiState = HomeUIState.Success(fighters),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(
    name = "Error State Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Error State Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun HomeContentErrorPreview() {
    FighterRankComposeTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    {}, {}
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            HomeContent(
                onNavigateToDetail = {},
                uiState = HomeUIState.Error(stringResource(R.string.failed_to_load_fighters)),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}