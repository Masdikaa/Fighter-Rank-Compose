package com.masdika.fighterrankcompose.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun FighterList(modifier: Modifier = Modifier) {
    val fighterListState = rememberLazyListState()

    LazyColumn(
        state = fighterListState,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(50) {
            FighterCard(
                fighterImage = "",
                fighterName = "Fighter Name",
                fighterDivision = "Fighter Division",
                fighterDescription = "Fighter Description"
            )
        }
    }
}


@Preview
@Composable
private fun FighterListPreview() {
    FighterRankComposeTheme {
        FighterList()
    }
}