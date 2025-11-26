package com.masdika.fighterrankcompose.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.components.icons.FighterIcon
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed
import com.masdika.fighterrankcompose.ui.theme.Sternbach

@Composable
fun TopAppBar(
    onShowDropdownMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .statusBarsPadding()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = stringResource(R.string.title),
                fontFamily = Sternbach,
                color = MainRed,
                fontSize = 30.sp,
                letterSpacing = 0.2.sp
            )
            Icon(
                imageVector = FighterIcon,
                contentDescription = stringResource(R.string.app_icon_description),
                tint = MainRed,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onShowDropdownMenu
                    )
            )
        }
        HorizontalDivider(
            color = MainRed,
            thickness = (2.5).dp
        )
    }
}

@Preview(
    name = "Top Bar Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Top Bar Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun TopAppBarHomePreview() {
    FighterRankComposeTheme {
        Scaffold(
            topBar = { TopAppBar({}) },
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            Box(Modifier.padding(innerPadding))
        }
    }
}