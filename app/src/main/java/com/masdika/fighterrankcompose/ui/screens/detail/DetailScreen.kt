package com.masdika.fighterrankcompose.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterDescription
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterOverview
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterStatisticChart
import com.masdika.fighterrankcompose.ui.screens.detail.components.ShareButton
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun DetailScreen(
    fighter: Fighter,
    onShareButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        FighterOverview(
            fighterImage = fighter.image,
            fighterName = fighter.name,
            fighterTitle = fighter.title,
            fighterDivision = fighter.division,
            fighterWins = fighter.wins,
            fighterDraws = fighter.draws,
            fighterLoses = fighter.loses,
            fighterWinByKnockout = fighter.knockOutWins,
            fighterWinBySubmission = fighter.submissionWins,
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
                onShareButtonClick = onShareButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            )
        }
    }
}

@Preview(
    name = "Detail Screen Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Detail Screen Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DetailScreenPreview() {
    FighterRankComposeTheme {
        val fighter = Fighter(
            image = "",
            name = "Alexander Volkanovski",
            division = "Lightweight",
            description = "Description",
            wins = 54,
            loses = 0,
            draws = 0,
            strikeAccuracy = 89.0,
            takedownAccuracy = 87.0,
            knockOutWins = 49,
            submissionWins = 3,
            title = "\"El Macho\""
        )

        DetailScreen(fighter, {})
    }
}