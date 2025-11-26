package com.masdika.fighterrankcompose.ui.screens.detail

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterDescription
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterOverview
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterStatisticChart
import com.masdika.fighterrankcompose.ui.screens.detail.components.ShareButton
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun DetailScreen(
    fighterName: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel<DetailViewModel>()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = fighterName) {
        viewModel.findFighterByName(fighterName)
    }

    DetailContent(
        uiState = uiState,
        onShareClick = { onShareClick() },
        modifier = modifier
    )
}

@Composable
fun DetailContent(
    uiState: DetailUIState,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is DetailUIState.Loading -> {
                CircularProgressIndicator(color = MainRed)
            }

            is DetailUIState.Success -> {
                val fighter = uiState.fighter
                val scrollState = rememberScrollState()

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    FighterOverview(
                        fighter = fighter,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.32f)
                            .background(MaterialTheme.colorScheme.background)
                            .padding(start = 15.dp, end = 5.dp)
                    )
                    HorizontalDivider(color = MainRed, thickness = 5.dp)
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 10.dp)
                            .background(MaterialTheme.colorScheme.background)
                            .verticalScroll(scrollState)
                    ) {
                        FighterDescription(
                            fighterName = fighter.name,
                            fighterDescription = fighter.description,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        )
                        FighterStatisticChart(
                            fighterName = fighter.name,
                            fighterStrikeAccuracy = fighter.strikeAccuracy,
                            fighterTakedownAccuracy = fighter.takedownAccuracy,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                        )
                        ShareButton(
                            onShareClick = { onShareClick() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        )
                    }
                }
            }

            is DetailUIState.Error -> {
                Text(
                    text = "Fighter not found!",
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

fun onShareClick() {
    Log.i("onShareClick", "Clicked")
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
private fun DetailContentSuccessPreview() {
    val mockFighter = Fighter(
        name = "Conor McGregor",
        division = "Lightweight",
        image = "",
        description = "Conor Anthony McGregor is an Irish professional mixed martial artist. He is a former Ultimate Fighting Championship (UFC) featherweight and lightweight double-champion.",
        wins = 22,
        losses = 6,
        draws = 0,
        strikeAccuracy = 55.1,
        takedownAccuracy = 55.0,
        knockOutWins = 5,
        submissionWins = 2,
        title = "\"The Notorius\"",
    )

    FighterRankComposeTheme {
        DetailContent(
            uiState = DetailUIState.Success(mockFighter),
            onShareClick = {},
        )
    }
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
private fun DetailContentLoadingPreview() {
    FighterRankComposeTheme {
        DetailContent(
            uiState = DetailUIState.Loading,
            onShareClick = {},
        )
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
private fun DetailContentErrorPreview() {
    FighterRankComposeTheme {
        DetailContent(
            uiState = DetailUIState.Error(stringResource(R.string.fighter_not_found)),
            onShareClick = {},
        )
    }
}