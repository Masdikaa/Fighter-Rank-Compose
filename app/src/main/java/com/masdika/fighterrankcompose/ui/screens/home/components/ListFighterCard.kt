package com.masdika.fighterrankcompose.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.source.loadFighters
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed
import com.masdika.fighterrankcompose.ui.theme.MavenPro

@Composable
fun ListFighterCard(
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
    ) {
        AsyncImage(
            model = fighterImage,
            contentDescription = fighterName + stringResource(R.string.fighter_image),
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .width(90.dp)
                .fillMaxHeight()
                .padding(top = 5.dp, start = 8.dp)
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 8.dp)
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = fighterName,
                fontFamily = BebasNeue,
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
                fontFamily = FontFamily.SansSerif,
                maxLines = 5,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = true
                    ), lineHeightStyle = LineHeightStyle(
                        trim = LineHeightStyle.Trim.Both,
                        alignment = LineHeightStyle.Alignment.Top,
                    )
                ),
                modifier = Modifier.padding(top = 4.dp)
            )

        }
    }
}

@Preview(
    name = "Fighter Card Preview Light Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Fighter Card Preview Dark Mode",
    showBackground = true,
    widthDp = 425,
    heightDp = 944,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ListFighterCardPreview() {
    val fighters = loadFighters(LocalContext.current)
    val fighter = fighters.getOrNull(1)
    FighterRankComposeTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ListFighterCard(
                fighterImage = fighter!!.image,
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
            )
        }
    }
}