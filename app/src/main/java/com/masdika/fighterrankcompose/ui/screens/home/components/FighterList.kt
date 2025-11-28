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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.data.source.loadFighters
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun FighterList(
    fighters: List<Fighter>,
    onNavigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
    fighterListState: LazyListState = rememberLazyListState()
) {
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
        val fighters = loadFighters(LocalContext.current)
        FighterList(
            fighters = fighters,
            onNavigateToDetail = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}