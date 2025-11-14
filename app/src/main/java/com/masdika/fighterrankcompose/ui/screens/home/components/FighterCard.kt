package com.masdika.fighterrankcompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed
import com.masdika.fighterrankcompose.ui.theme.MavenPro

@Composable
fun FighterCard(
    fighterImage: String,
    fighterName: String,
    fighterDivision: String,
    fighterDescription: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .height(135.dp)
            .padding(top = 3.dp, start = 3.dp)
            .background(MaterialTheme.colorScheme.background)
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = MainRed,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        AsyncImage(
            model = fighterImage,
            contentDescription = fighterName + stringResource(R.string.fighter_image),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .width(90.dp)
                .fillMaxHeight()
                .padding(top = 5.dp)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .background(MaterialTheme.colorScheme.surface)
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = fighterName,
                fontFamily = MavenPro,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 5.dp)
            )

            Text(
                text = fighterDivision.uppercase() + " DIVISION",
                fontFamily = MavenPro,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                overflow = TextOverflow.Clip,
            )

            Text(
                text = fighterDescription,
                fontFamily = MavenPro,
                maxLines = 3,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 4.dp)
            )

        }
    }
}

@Preview
@Composable
private fun FighterCardPreview() {
    FighterRankComposeTheme {
        FighterCard(
            fighterImage = "",
            fighterName = "Fighter Name",
            fighterDivision = "Fighter Division",
            fighterDescription = "Fighter Description"
        )
    }
}