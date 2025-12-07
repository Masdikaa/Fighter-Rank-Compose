package com.masdika.fighterrankcompose.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun FighterList(
    fighters: List<Fighter>,
    onNavigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    isGridLayout: Boolean,
    fighterListState: LazyListState,
    fighterGridState: LazyGridState,
) {
    if (!isGridLayout) {
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
                ListFighterCard(
                    fighter = fighter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(135.dp)
                        .background(MaterialTheme.colorScheme.background)
                        .clip(RoundedCornerShape(5.dp))
                        .border(
                            width = 1.dp,
                            color = MainRed,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable(
                            onClick = { onNavigateToDetail(fighter.id) }
                        )
                )
            }
        }
    } else {
        LazyVerticalGrid(
            state = fighterGridState,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 5.dp,
                    bottom = 0.dp
                )
        ) {
            items(
                items = fighters,
                key = { it.name }
            ) { fighter ->
                GridFighterCard(
                    fighter = fighter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .border(
                            width = 1.dp,
                            color = MainRed,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable(
                            onClick = { onNavigateToDetail(fighter.id) }
                        )
                )
            }
        }
    }
}

@Preview(
    name = "FighterList Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "FighterList Dark Mode",
    showBackground = true,
    backgroundColor = 0xFF121316C,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun FighterListPreview() {
    FighterRankComposeTheme {
//        val fighters = loadFighters(LocalContext.current)
//        FighterList(
//            fighters = fighters,
//            onNavigateToDetail = {},
//            isGridLayout = true,
//            modifier = Modifier.fillMaxSize()
//        )
    }
}