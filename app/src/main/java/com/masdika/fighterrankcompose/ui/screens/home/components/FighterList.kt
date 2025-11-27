package com.masdika.fighterrankcompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun FighterList(
    fighters: List<Fighter>,
    onNavigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val fighterListState = rememberLazyListState()
    LazyColumn(
        state = fighterListState,
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 5.dp,
                bottom = 0.dp
            ),
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        width = 1.dp,
                        color = MainRed,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable(
                        onClick = { onNavigateToDetail(fighter.name) }
                    )
            )
        }
    }
}