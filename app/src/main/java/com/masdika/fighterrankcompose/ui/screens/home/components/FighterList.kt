package com.masdika.fighterrankcompose.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.source.loadFighters
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme

@Composable
fun FighterList(
    fighters: List<Fighter>,
    modifier: Modifier = Modifier
) {
    val fighterListState = rememberLazyListState()

    LazyColumn(
        state = fighterListState,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(
            items = fighters,
            key = { it.name }
        ) { fighter ->
            FighterCard(
                fighterImage = fighter.image,
                fighterName = fighter.name,
                fighterDivision = fighter.division,
                fighterDescription = fighter.description,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
private fun FighterListPreview() {
    val fighters = loadFighters(LocalContext.current)
 
    FighterRankComposeTheme {
        FighterList(fighters)
    }
}