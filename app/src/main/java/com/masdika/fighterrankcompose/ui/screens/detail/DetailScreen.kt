package com.masdika.fighterrankcompose.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.screens.detail.components.FighterOverview
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun DetailScreen(
    fighter: Fighter,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val horizontalGuideline = createGuidelineFromTop(0.32f)
        val (fighterOverview) = createRefs()

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
            modifier = modifier.constrainAs(fighterOverview) {
                top.linkTo(anchor = parent.top)
                start.linkTo(anchor = parent.start)
                end.linkTo(anchor = parent.end)
                bottom.linkTo(anchor = horizontalGuideline)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
        )
    }
}

@Preview(
    name = "Detail Screen",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
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