package com.masdika.fighterrankcompose.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterOverview
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun DetailScreen(
    fighter: Fighter,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
    ) {
        val horizontalGuideline = createGuidelineFromTop(0.32f)
        val (
            fighterOverview,
            horizontalDivider,
            fighterDescriptionLayout
        ) = createRefs()

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
            modifier = Modifier.constrainAs(fighterOverview) {
                top.linkTo(anchor = parent.top)
                start.linkTo(anchor = parent.start)
                end.linkTo(anchor = parent.end)
                bottom.linkTo(anchor = horizontalGuideline)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
        )

        HorizontalDivider(
            modifier = Modifier
                .constrainAs(horizontalDivider) {
                    top.linkTo(anchor = fighterOverview.bottom)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(5.dp)
                }
                .background(MainRed)
        )

        Box(
            modifier = Modifier
                .constrainAs(fighterDescriptionLayout) {
                    top.linkTo(anchor = horizontalDivider.bottom)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                    bottom.linkTo(anchor = parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(MaterialTheme.colorScheme.background)
        )
    }
}

@Preview(
    name = "Detail Screen Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Detail Screen Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun DetailScreenPreview() {
    FighterRankComposeTheme {
        val fighter = Fighter(
            image = "",
            name = "Masdika Ilhan Mansiz",
            division = "Lightweight",
            description = "Description",
            wins = 54,
            loses = 0,
            draws = 0,
            strikeAccuracy = 89,
            takedownAccuracy = 87,
            knockOutWins = 49,
            submissionWins = 3,
            title = "\"El Macho\""
        )

        DetailScreen(fighter)
    }
}