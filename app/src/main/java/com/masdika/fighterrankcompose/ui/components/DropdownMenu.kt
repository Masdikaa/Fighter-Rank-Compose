package com.masdika.fighterrankcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.components.icons.AboutIcon
import com.masdika.fighterrankcompose.ui.components.icons.FighterIcon
import com.masdika.fighterrankcompose.ui.components.icons.SourceCodeIcon
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun DropdownMenu(
    onNavigateToProfileScreen: () -> Unit,
    onNavigateToSourceCodeScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Icon(
            imageVector = FighterIcon,
            contentDescription = stringResource(R.string.app_icon_description),
            tint = MainRed,
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable(
                    onClick = { expanded = true }
                )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background.copy(
                    alpha = 0.1f,
                    red = 1f,
                    green = 1f,
                    blue = 1f
                )
            )
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = "About and Profile",
                        fontFamily = BebasNeue,
                        fontSize = 18.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = AboutIcon,
                        contentDescription = "About Icon",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
                onClick = {
                    expanded = false
                    onNavigateToProfileScreen()
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Source Code",
                        fontFamily = BebasNeue,
                        fontSize = 18.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = SourceCodeIcon,
                        contentDescription = stringResource(R.string.source_code),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
                onClick = {
                    expanded = false
                    onNavigateToSourceCodeScreen()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DropdownMenuPreview() {
    FighterRankComposeTheme {
        DropdownMenu({}, {})
    }
}