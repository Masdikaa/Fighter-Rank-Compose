package com.masdika.fighterrankcompose.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.data.source.loadFighters
import com.masdika.fighterrankcompose.ui.screens.home.components.FighterList
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val fighters = remember { loadFighters(context) }

    Box(
        modifier = modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 5.dp,
                bottom = 0.dp
            )
            .background(MaterialTheme.colorScheme.surface)
    ) {
        FighterList(fighters)
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FighterRankComposeTheme {
        HomeScreen()
    }
}