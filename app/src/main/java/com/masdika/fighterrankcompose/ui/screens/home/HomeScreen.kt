package com.masdika.fighterrankcompose.ui.screens.home

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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masdika.fighterrankcompose.ui.components.TopAppBar
import com.masdika.fighterrankcompose.ui.screens.home.components.FighterList
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun HomeScreen(
    onNavigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                onShowDropdownMenu = { onShowDropDownMenu() }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val state = uiState) {
                is HomeUIState.Loading -> {
                    CircularProgressIndicator(color = MainRed)
                }

                is HomeUIState.Success -> {
                    FighterList(
                        fighters = state.fighters,
                        onNavigateToDetail = onNavigateToDetail,
                        modifier = Modifier.fillMaxSize(),
                    )
                }

                is HomeUIState.Error -> {
                    Text(
                        text = "Failed to load fighter!",
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

fun onShowDropDownMenu() {
    Log.i("onShowDropDownMenu", "Clicked")
}

