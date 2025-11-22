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
    FighterRankComposeTheme {
        val description =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\nUt enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        FighterDescription(
            fighterName = "Fighter Name",
            fighterDescription = description,
        )
    }
}