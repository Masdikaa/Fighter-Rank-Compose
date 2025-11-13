package com.masdika.fighterrankcompose.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.ui.screens.home.components.FighterList
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 5.dp,
                bottom = 0.dp
            )
            .background(MaterialTheme.colorScheme.surface)
    ) {
        FighterList()
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FighterRankComposeTheme {
        HomeScreen()
    }
}