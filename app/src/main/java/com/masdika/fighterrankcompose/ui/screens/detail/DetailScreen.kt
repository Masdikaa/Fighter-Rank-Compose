package com.masdika.fighterrankcompose.ui.screens.detail

import android.content.res.Configuration
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
    onShareClick: () -> Unit,
    uiState: DetailUIState,
    modifier: Modifier = Modifier,
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

@Preview(
    name = "Detail Screen Success Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Detail Screen Success Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DetailScreenSuccessPreview() {
    FighterRankComposeTheme {
        val fighter = Fighter(
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
        )
        DetailScreen(
            onShareClick = {},
            uiState = DetailUIState.Success(fighter),
        )
    }
}

@Preview(
    name = "Detail Screen Loading Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Detail Screen Loading Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DetailScreenLoadingPreview() {
    FighterRankComposeTheme {
        DetailScreen(
            onShareClick = {},
            uiState = DetailUIState.Loading,
        )
    }
}

@Preview(
    name = "Detail Screen Error Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Detail Screen Error Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DetailScreenErrorPreview() {
    FighterRankComposeTheme {
        DetailScreen(
            onShareClick = {},
            uiState = DetailUIState.Error(stringResource(R.string.fighter_not_found)),
        )
    }
}