package com.masdika.fighterrankcompose.ui.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masdika.fighterrankcompose.ui.components.ShareIcon
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Composable
fun ShareButton(
    onShareButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onShareButtonClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonColors(
            containerColor = MainRed,
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray
        ),
        content = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Share Profile",
                    fontFamily = BebasNeue,
                    fontSize = 18.sp
                )
                Spacer(Modifier.width(10.dp))
                Icon(
                    imageVector = ShareIcon,
                    contentDescription = "Share Icon",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp),
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ShareButtonPreview() {
    FighterRankComposeTheme {
        ShareButton({})
    }
}