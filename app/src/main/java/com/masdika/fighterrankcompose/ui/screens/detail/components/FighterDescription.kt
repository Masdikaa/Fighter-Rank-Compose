package com.masdika.fighterrankcompose.ui.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun FighterDescription(
    fighterName: String,
    fighterDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Text(
            text = fighterName,
            fontFamily = BebasNeue,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = fighterDescription,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = true
                ),
                lineHeightStyle = LineHeightStyle(
                    trim = LineHeightStyle.Trim.Both,
                    alignment = LineHeightStyle.Alignment.Top,
                )
            ),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FighterDescriptionPreview() {
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
    FighterRankComposeTheme {
        FighterDescription(
            fighterName = fighter.name,
            fighterDescription = fighter.description,
        )
    }
}