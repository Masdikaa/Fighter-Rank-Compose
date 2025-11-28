package com.masdika.fighterrankcompose.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.Fighter
import com.masdika.fighterrankcompose.ui.theme.BebasNeue
import com.masdika.fighterrankcompose.ui.theme.MavenPro

@Composable
fun GridFighterCard(
    fighter: Fighter,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
    ) {
        AsyncImage(
            model = fighter.image,
            contentDescription = fighter.name + stringResource(R.string.fighter_image),
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            error = painterResource(R.drawable.ic_launcher_background),
            modifier = Modifier
                .padding(start = 3.dp)
                .fillMaxHeight(0.95f)
        )
        Spacer(Modifier.width(3.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight(0.95f)
                .fillMaxWidth()
                .padding(end = 5.dp)
        ) {
            Text(
                text = fighter.name,
                fontFamily = BebasNeue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = true
                    ), lineHeightStyle = LineHeightStyle(
                        trim = LineHeightStyle.Trim.Both,
                        alignment = LineHeightStyle.Alignment.Top,
                    )
                )
            )
            if (fighter.title.isNotEmpty()) {
                Text(
                    text = fighter.title.uppercase(),
                    fontFamily = MavenPro,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = true
                        ), lineHeightStyle = LineHeightStyle(
                            trim = LineHeightStyle.Trim.Both,
                            alignment = LineHeightStyle.Alignment.Top,
                        )
                    )
                )
            }
            Text(
                text = fighter.division,
                fontFamily = BebasNeue,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
            )
            Text(
                text = fighter.description,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
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
            )
        }
    }
}