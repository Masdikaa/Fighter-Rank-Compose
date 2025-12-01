package com.masdika.fighterrankcompose.ui.screens.about.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun ContentAbout(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Spacer(Modifier.height(10.dp))
        Text(
            text = "About This Project",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 10.dp)

        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.about_description),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontFamily = FontFamily.Default,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(Modifier.height(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentAboutPreview() {
    FighterRankComposeTheme {
        ContentAbout()
    }
}